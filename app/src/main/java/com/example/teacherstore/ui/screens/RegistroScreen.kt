package com.example.teacherstore.ui.screens

import android.R
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.teacherstore.viewmodel.UsuarioViewModel


@Composable
fun RegistroScreen(

    viewModel: UsuarioViewModel,
    navController: NavController
){
    val estado by viewModel.estado.collectAsState()
    Column(
        Modifier
            .fillMaxSize()
            .padding(16 .dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)

    ){
        OutlinedTextField(
            value = estado.nombre,
            onValueChange = viewModel::onNombreChange,
            label = {Text("Nombre")},
            isError = estado.errores.nombre!=null,
            supportingText = {
                estado.errores.nombre?.let{
                    Text(it, color = MaterialTheme.colorScheme.error)
                }
            }


        )

    }


}