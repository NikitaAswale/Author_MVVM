package com.example.author_mvvm

import retrofit2.http.GET

interface APIService {

    @GET("posts")
    suspend fun GetPosts(): List<Posts>
}