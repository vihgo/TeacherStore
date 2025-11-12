package com.example.teacherstore.ui.screens

import android.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.teacherstore.viewmodel.PostViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostScreen(viewModel: PostViewModel){
    //observamos el flujo de datos del ViewModel

    val posts= viewModel.postList.collectAsState().value

    Scaffold(topBar = {
        TopAppBar(title = {Text("Ultimos Posts")})
    })
    {
        innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
        ){
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)


            ){
                items(posts){
                    post->
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)

                    ) {
                        Column(modifier = Modifier.padding(16.dp))
                        {
                            Text(text = "Titulo: ${post.title}",
                                style = MaterialTheme.typography.titleMedium
                                )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(text = post.body,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }

                    }
                }
            }

        }



    }


}