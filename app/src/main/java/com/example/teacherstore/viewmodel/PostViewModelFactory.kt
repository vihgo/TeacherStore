package com.example.teacherstore.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.teacherstore.repository.PostRepository
import kotlinx.coroutines.Dispatchers

class PostViewModelFactory(
    private val repo: PostRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostViewModel(
            repository = repo,
            dispatcher = Dispatchers.IO
        ) as T
    }
}
