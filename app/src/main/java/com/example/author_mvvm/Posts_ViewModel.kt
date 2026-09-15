package com.example.author_mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class Posts_ViewModel : ViewModel() {

    private val repository = Posts_Repository()

    private val _posts = MutableStateFlow<List<Posts>>(emptyList())
    val posts : StateFlow<List<Posts>> = _posts

    init {
        fetchPosts()
    }

    fun fetchPosts(){
        viewModelScope.launch {
            _posts.value = repository.GetPosts()
        }
    }
}