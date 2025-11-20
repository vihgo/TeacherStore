package com.example.teacherstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.teacherstore.repository.PostRepository
import com.example.teacherstore.ui.screens.PostScreen
import com.example.teacherstore.ui.theme.TeacherStoreTheme
import com.example.teacherstore.viewmodel.PostViewModel
import com.example.teacherstore.viewmodel.PostViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            TeacherStoreTheme {
                val vm: PostViewModel = viewModel(
                    factory = PostViewModelFactory(PostRepository())
                )
                PostScreen(viewModel = vm)
            }
        }
    }
}
