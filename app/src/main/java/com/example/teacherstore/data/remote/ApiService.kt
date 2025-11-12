package com.example.teacherstore.data.remote

import com.example.teacherstore.data.model.Post
import retrofit2.http.GET

//LA INTERFAZ QUE DEFINE  LOS ENDPOINTS HTTP
interface ApiService {
    @GET("/posts")
    suspend fun getPosts(): List<Post>
}