package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var rvUserList: RecyclerView
    private lateinit var userList: java.util.ArrayList<User>
    private lateinit var userAdaptor: UserAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userList = ArrayList()
        rvUserList = findViewById(R.id.rvList)
        rvUserList.layoutManager = LinearLayoutManager(this)
        userAdaptor = UserAdaptor(this,userList )
        rvUserList.adapter = userAdaptor
        fetchUsers()
    }

    private fun fetchUsers() {
        RetrofitClient.api.getUsers().enqueue(object : Callback<List<User>>{
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if(response.body() != null){
                    userList.addAll(response.body()!!)
                    userAdaptor.notifyDataSetChanged()
                }
                else if(response.errorBody() != null){
                    Log.e( "onResponse: ", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e( "onFailure: ",t.message.toString() )
            }

        })
    }
}

