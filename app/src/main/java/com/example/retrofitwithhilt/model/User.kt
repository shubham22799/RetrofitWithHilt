package com.example.retrofitwithhilt.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val per_page: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_page")
    val total_page: Int,
    @SerializedName("data")
    val UserData: List<UserData>? = null
    ): Serializable

data class UserData(
    @SerializedName("id")
    val id: Int,
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
    val first_name: String,
    @SerializedName("last_name")
    val last_name: String,
    @SerializedName("avatar")
    val avatar: String,
): Serializable