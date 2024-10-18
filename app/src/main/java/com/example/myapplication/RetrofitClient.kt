package com.example.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL ="https://jsonplaceholder.typicode.com/"
//    val api = ApiService by lazy{
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConvertorFactory(GsonConvertorFactory.create())
//            .build()
//            .create(ApiService::class.java)
//    }
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}