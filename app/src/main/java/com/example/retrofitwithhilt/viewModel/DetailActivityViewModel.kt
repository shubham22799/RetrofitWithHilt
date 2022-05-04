package com.example.retrofitwithhilt.viewModel

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.retrofitwithhilt.model.ApiService
import com.example.retrofitwithhilt.model.Register
import com.example.retrofitwithhilt.model.User
import com.example.retrofitwithhilt.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class DetailActivityViewModel @Inject constructor(private val repository: Repository): ViewModel(){
    val TAG = "DetailActivityViewModel"
      fun post(request: Register) {
        repository.post(request).enqueue(object: retrofit2.Callback<com.example.retrofitwithhilt.model.Response>{
            override fun onResponse(
                call: Call<com.example.retrofitwithhilt.model.Response>,
                response: Response<com.example.retrofitwithhilt.model.Response>
            ) {
                Log.v(TAG, response.body()?.userToken.toString())
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onFailure(
                call: Call<com.example.retrofitwithhilt.model.Response>,
                t: Throwable
            ) {
                Log.v(TAG, t.message.toString())
            }
        })
    }


}