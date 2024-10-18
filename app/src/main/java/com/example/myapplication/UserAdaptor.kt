package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdaptor(private val context : Context, private val userList:List<User>) : RecyclerView.Adapter<UserAdaptor.viewholder>(){

    class viewholder(view: View) : RecyclerView.ViewHolder(view) {
        val id : TextView = view.findViewById(R.id.userId)
        val companyName : TextView = view.findViewById(R.id.companyName)
        val lat : TextView = view.findViewById(R.id.lat)
        val longitude : TextView = view.findViewById(R.id.longitude)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_list_item, parent, false)
        return viewholder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val user = userList[position]
        holder.id.text = user.id.toString()
        holder.companyName.text = user.company.name
        holder.longitude.text = user.address.geo.lng
        holder.lat.text = user.address.geo.lat
    }


}