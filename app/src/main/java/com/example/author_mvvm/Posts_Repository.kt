package com.example.author_mvvm

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Posts_Repository {

    private val apiService = RetrofitInstance.api

    suspend fun GetPosts(): List<Posts> {
        return withContext(Dispatchers.IO) {
            try {
                apiService.GetPosts()
            } catch (e: Exception) {
                e.printStackTrace()
                emptyList()
            }
        }
    }
}