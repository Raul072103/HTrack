package com.raul.myapplication.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
    val dob: String,
    val email: String,
    @SerialName(value = "etnicity")
    val ethnicity: String, // TODO(ANTONIO SCHIMBA "ETNICITY" IN "ETHNICITY")
    @SerialName(value = "first_name")
    val firstName: String,
    val gender: String,
    @SerialName(value = "last_name")
    val lastName: String,
    val password: String, // TODO(CE FACEM CU PAROLA??)
    @SerialName(value = "phone_nr")
    val phoneNumber: String,
    val username: String

)

