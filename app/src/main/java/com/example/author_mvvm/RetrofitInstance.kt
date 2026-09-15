package com.example.author_mvvm

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import kotlin.getValue
import kotlin.jvm.java

object RetrofitInstance {

    private const val Base_URL = "https://jsonplaceholder.typicode.com/"

    val api:APIService by lazy {
        Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }
}