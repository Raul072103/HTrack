package com.raul.myapplication.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.raul.myapplication.ui.screens.login.LogInScreen

@Composable
fun HealthMonitoringApp() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        LogInScreen()
    }

}