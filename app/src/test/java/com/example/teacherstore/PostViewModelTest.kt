package com.example.teacherstore

import com.example.teacherstore.data.model.Post
import com.example.teacherstore.data.remote.ApiService
import com.example.teacherstore.viewmodel.PostViewModel
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest

@OptIn(ExperimentalCoroutinesApi::class)
class PostViewModelTest : StringSpec({

    "postList se actualiza correctamente tras fetchPosts()" {
        val fakePosts = listOf(
            Post(1,1,"Titulo 1","Contenido 1"),
            Post(2,2,"Titulo 2","Contenido 2")
        )

        // Mock API
        val mockApi = mockk<ApiService>()
        coEvery { mockApi.getPosts() } returns fakePosts

        // Repositorio de test usando tu clase
        val testRepo = TestTablePostRepository(mockApi)

        // Dispatcher de test
        val dispatcher = StandardTestDispatcher()

        // ViewModel testeable con DI
        val viewModel = PostViewModel(testRepo, dispatcher)

        runTest(dispatcher) {
            viewModel.fetchPosts()
            advanceUntilIdle()

            viewModel.postList.value shouldContainExactly fakePosts
        }
    }
})
