package com.example.teacherstore.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.dayContentDescription
import androidx.compose.runtime.Composable


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onGoProfile:() -> Unit,
    onOpenDrawer:() -> Unit,

){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Home") },
                navigationIcon = {
                    IconButton(onClick = onOpenDrawer) {
                        Icon(imageVector = Icons.Filled.Menu,
                        contentDescription= "Abrir Menu"
                        )
                    }

                }
            )
        }
    ){
      //  padding ->
       // Column {  }


    }


}