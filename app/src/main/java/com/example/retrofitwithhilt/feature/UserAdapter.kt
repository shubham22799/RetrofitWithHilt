package com.example.retrofitwithhilt.feature

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitwithhilt.R
import com.example.retrofitwithhilt.model.UserData
import de.hdodenhof.circleimageview.CircleImageView


class UserAdapter(private val context: Context, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private val userList = ArrayList<UserData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position], listener)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun updateList(list: List<UserData>?) {
        Log.v("list", list.toString())
        userList.clear()
        userList.addAll(list!!)

    }

    interface OnItemClickListener {
        fun onItemClick(userData: UserData)
    }

    inner class UserViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

         fun bind(userData: UserData, listener: OnItemClickListener) {
            Log.v("Items", userData.toString())
            val image = view.findViewById<CircleImageView>(R.id.imageview)
            val name = view.findViewById<TextView>(R.id.tv_name)
            val email = view.findViewById<TextView>(R.id.tv_email)
            val ll = view.findViewById<LinearLayout>(R.id.ll)

            name.text = userData.first_name
            email.text = userData.email
            Glide.with(context)
                .load(userData.avatar)
                .into(image)
            ll.setOnClickListener { listener.onItemClick(userData) }
        }
    }
}

