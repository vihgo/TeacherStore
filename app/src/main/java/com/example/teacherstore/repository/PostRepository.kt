package com.example.teacherstore.repository

import com.example.teacherstore.data.model.Post
import com.example.teacherstore.data.remote.RetrofitInstance

class PostRepository {
    suspend fun getPosts(): List<Post>{
        return RetrofitInstance.api.getPosts()
    }
}