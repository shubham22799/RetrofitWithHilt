package com.example.retrofitwithhilt.repository

import com.example.retrofitwithhilt.model.ApiService
import com.example.retrofitwithhilt.model.Register
import com.example.retrofitwithhilt.model.Response
import com.example.retrofitwithhilt.model.User
import retrofit2.Call
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val apiService: ApiService): Repository {
    override fun getUser(): Call<User> {
        return apiService.getUser()
    }

    override fun post(register: Register): Call<Response> {
        return apiService.postUser(register)
    }
}