package com.raul.myapplication.data

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.raul.myapplication.data.remote.network.RegistrationApiService
import com.raul.myapplication.data.repository.LogInRepository
import com.raul.myapplication.data.repository.NetworkLogInRepository
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import okhttp3.MediaType.Companion.toMediaType

interface AppContainer {
    val logInRepository: LogInRepository
}

class DefaultAppContainer() : AppContainer {
    private val baseUrl = "http://192.168.0.168:8080/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(
            Json{
                ignoreUnknownKeys = true
            }
            .asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: RegistrationApiService by lazy {
        retrofit.create(RegistrationApiService::class.java)
    }

    override val logInRepository: LogInRepository by lazy {
        NetworkLogInRepository(retrofitService)
    }

}