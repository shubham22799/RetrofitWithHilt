package com.example.retrofitwithhilt.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Response(
    @SerializedName("id")
    val userId: Int,
    @SerializedName("token")
    val userToken: String
): Serializable
