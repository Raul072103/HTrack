package com.raul.myapplication.data.remote.network

import com.raul.myapplication.data.remote.model.User
import retrofit2.Response
import retrofit2.http.Body

import retrofit2.http.POST

interface RegistrationApiService {

    @POST("/posts")
    suspend fun createPost(@Body user: User): Response<User>

}