package com.example.retrofitwithhilt.feature

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout.HORIZONTAL
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitwithhilt.*
import com.example.retrofitwithhilt.databinding.ActivityMainBinding
import com.example.retrofitwithhilt.model.UserData
import com.example.retrofitwithhilt.viewModel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainActivityViewModel by viewModels<MainActivityViewModel>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = mainActivityViewModel
        binding.lifecycleOwner = this
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter(this, object : UserAdapter.OnItemClickListener {
            override fun onItemClick(userData: UserData) {
                val i = Intent(this@MainActivity, DetailActivity::class.java)
                i.putExtra("item", userData)
                startActivity(i)
            }
        })
        binding.recyclerView.adapter = userAdapter
        mainActivityViewModel.getUserData(userAdapter)
        mainActivityViewModel.getData().observe(this){
            userAdapter.updateList(it)
            userAdapter.notifyDataSetChanged()
        }

    }
}