package com.example.teacherstore.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import com.example.teacherstore.viewmodel.MainViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.teacherstore.navigation.AppRoute


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    viewModel: MainViewModel= viewModel(),
    navController: NavController
){
    val items= listOf(AppRoute.Home, AppRoute.Profile)
    var selectedItem by remember { mutableIntStateOf(1) }

    Scaffold(
        bottomBar ={
            NavigationBar {
                items.forEachIndexed { index,approute ->
                    NavigationBarItem(
                        selected= selectedItem==index,
                        onClick = {
                            selectedItem=index
                            viewModel.navigateTo(approute)
                        },
                        label = {Text(approute.route)},
                        icon = {
                            Icon(imageVector = if(approute== AppRoute.Home) Icons.Default.Home else Icons.Default.Person,
                                contentDescription = approute.route
                            )

                        }

                    )
                }
            }
        }

    )
    { innerPadding->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Text("Bienvenido al Perfil")
        }

    }


}