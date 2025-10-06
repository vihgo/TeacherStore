package com.example.teacherstore.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import com.example.teacherstore.viewmodel.MainViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.teacherstore.navigation.AppRoute
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: MainViewModel= viewModel(),
    navController: NavController
){
    val drawerState= rememberDrawerState(DrawerValue.Closed)
    val scope= rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState=drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Menu",Modifier.padding(16.dp))
                NavigationDrawerItem(
                    label = {Text("Ir al Perfil")},
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() }
                        viewModel.navigateTo(AppRoute.Profile)
                    }
                )

            }
        }
    )
    {
        Scaffold (
            topBar = {
                TopAppBar(
                    title = {Text("Pantalla Home")},
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        )
        {innerPadding->
            Column(
                modifier= Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                horizontalAlignment= Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center



            ){
                Text("Bienvenido a la página  de Inicio")
                Spacer(modifier=Modifier.height(16.dp))
                Button(onClick = {viewModel.navigateTo(AppRoute.Settings)}) {

                }



            }



        }

    }

}