package com.example.retrofitwithhilt.model

import com.example.retrofitwithhilt.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("users")
    fun getUser(): Call<User>

    @POST("register")
    fun postUser(@Body register : Register): Call<Response>

}