package com.example.teacherstore.repository

import com.example.teacherstore.data.model.Post
import com.example.teacherstore.data.remote.RetrofitInstance

open class PostRepository {
   open  suspend fun getPosts(): List<Post>{
        return RetrofitInstance.api.getPosts()
    }
}