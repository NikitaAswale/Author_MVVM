package com.example.author_mvvm

import com.google.gson.annotations.SerializedName

data class Posts(
    @SerializedName("userId")
    val userID: Int,
    val id: Int,
    val title: String,
    val body: String
)
