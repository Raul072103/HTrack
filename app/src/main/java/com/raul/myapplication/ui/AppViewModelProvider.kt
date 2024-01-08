package com.raul.myapplication.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.raul.myapplication.HealthMonitoringApplication
import com.raul.myapplication.ui.screens.login.LogInViewModel

object AppViewModelProvider {

    val Factory = viewModelFactory {
        //Initializer foe LogInViewModel
        initializer {
            LogInViewModel(
                healthMonitoringApplication().container.logInRepository
            )
        }

    }

}

fun CreationExtras.healthMonitoringApplication() : HealthMonitoringApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as HealthMonitoringApplication)