package com.raul.myapplication.data.remote.network

import com.raul.myapplication.data.remote.model.User
import com.raul.myapplication.data.remote.model.UserLogIn
import retrofit2.Response
import retrofit2.http.Body

import retrofit2.http.POST

interface RegistrationApiService {

    // Account already crated, make the request to logIn
    @POST("/endpoint")
    fun logIn(@Body userLogIn: UserLogIn): User

    // Need to create account
    @POST("/endpoint")
    fun signUp(@Body user: User): Unit // TODO(CE PRIMESC CA RESPONSE CAND MA INREGISTREZ)


}