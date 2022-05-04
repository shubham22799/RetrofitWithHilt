package com.example.retrofitwithhilt.feature

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.retrofitwithhilt.R
import com.example.retrofitwithhilt.databinding.ActivityDetailBinding
import com.example.retrofitwithhilt.model.Register
import com.example.retrofitwithhilt.model.UserData
import com.example.retrofitwithhilt.viewModel.DetailActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val detailActivityViewModel by viewModels<DetailActivityViewModel>()

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = detailActivityViewModel
        binding.lifecycleOwner = this

        val item = intent.getSerializableExtra("item") as UserData
        val avatar = item.avatar
        val name = item.first_name
        val email = item.email

        name.apply {
            binding.tvName.text = name.ifEmpty { ("") }
        }
        email.apply {
            binding.tvEmail.text = email.ifEmpty { ("") }
        }
        avatar.apply {
            if (avatar.isNotEmpty()) {
                Glide.with(this@DetailActivity).load(avatar).into(binding.imageview)
            } else (binding.imageview.setImageDrawable(getDrawable(R.drawable.imagenotfound)))
        }

        binding.btnPost.setOnClickListener { userApiCall() }
    }

    private fun userApiCall() {
        val request = Register(binding.tvEmail.text.toString(), binding.tvName.text.toString())
        detailActivityViewModel.post(request)
    }

}