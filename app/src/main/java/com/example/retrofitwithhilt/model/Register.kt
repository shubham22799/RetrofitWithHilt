package com.example.retrofitwithhilt.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.io.SerializablePermission

data class Register(
    @field:SerializedName("email")
    val userEmail: String,
    @field:SerializedName("password")
    val pUserPassword: String,
    ): Serializable
