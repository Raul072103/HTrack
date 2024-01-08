package com.raul.myapplication

import android.app.Application
import com.raul.myapplication.data.AppContainer
import com.raul.myapplication.data.DefaultAppContainer

class HealthMonitoringApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }

}