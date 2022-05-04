package com.example.retrofitwithhilt.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.retrofitwithhilt.feature.UserAdapter
import com.example.retrofitwithhilt.model.User
import com.example.retrofitwithhilt.model.UserData
import com.example.retrofitwithhilt.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    private val TAG = "MainActivityViewModel"
    var output = MutableLiveData<String>()
    var input = MutableLiveData<String>()
    var data = ArrayList<UserData>()
    fun setText(){
        output.value = input.value
    }

    fun getUserData(userAdapter: UserAdapter) {
        repository.getUser().enqueue(object: retrofit2.Callback<User>{
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<User>, response: Response<User>) {
                userAdapter.updateList(response.body()?.UserData)
                userAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.v(TAG, t.message.toString())
            }
        })
    }
    fun getData()= liveData{
        emit(data)
    }
}