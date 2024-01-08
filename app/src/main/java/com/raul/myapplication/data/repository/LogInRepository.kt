package com.raul.myapplication.data.repository

import com.raul.myapplication.data.remote.model.User
import com.raul.myapplication.data.remote.network.RegistrationApiService
import retrofit2.Response

interface LogInRepository {
    suspend fun createPost(user: User) : Response<User>
}

class NetworkLogInRepository(
    private val registrationApiService: RegistrationApiService
) : LogInRepository {
    override suspend fun createPost(user: User): Response<User> {
        return registrationApiService.createPost(user)
    }
}