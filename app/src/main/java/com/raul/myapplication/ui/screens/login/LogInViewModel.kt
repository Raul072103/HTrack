package com.raul.myapplication.ui.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raul.myapplication.data.remote.model.User
import com.raul.myapplication.data.remote.model.UserLogIn
import com.raul.myapplication.data.repository.LogInRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface LogInUiState {
    data class Success(val user: User) : LogInUiState
    object Error : LogInUiState
    object Loading : LogInUiState
}

class LogInViewModel(
    private val logInRepository: LogInRepository
) : ViewModel() {

    var logInUiState: LogInUiState by mutableStateOf(LogInUiState.Loading)
        private set

    var currentUser: UserLogIn by mutableStateOf(UserLogIn("", ""))
        private set

    fun logIn(user: UserLogIn) {
        viewModelScope.launch {
            logInUiState = LogInUiState.Loading
            logInUiState = try {
                val response = logInRepository.logIn(user = user)
                LogInUiState.Success(response)
            } catch (e: HttpException) {
                e.printStackTrace()
                LogInUiState.Error
            } catch (e: IOException) {
                e.printStackTrace()
                LogInUiState.Error
            }
        }
    }

    fun updateUser(user: UserLogIn) {
        currentUser = user
    }

}