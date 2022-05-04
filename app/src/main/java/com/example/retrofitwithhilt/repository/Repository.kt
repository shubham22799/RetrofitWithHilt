package com.example.retrofitwithhilt.repository

import com.example.retrofitwithhilt.model.Register
import com.example.retrofitwithhilt.model.Response
import com.example.retrofitwithhilt.model.User
import retrofit2.Call

interface Repository {

    fun getUser(): Call<User>

    fun post(register: Register): Call<Response>
}
