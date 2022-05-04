package com.example.retrofitwithhilt.di

import com.example.retrofitwithhilt.model.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {
    private const val BASE_URL = "https://reqres.in/api/"

    @Provides
    @Singleton
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun apiService(): ApiService = getRetrofit().create(ApiService::class.java)
}