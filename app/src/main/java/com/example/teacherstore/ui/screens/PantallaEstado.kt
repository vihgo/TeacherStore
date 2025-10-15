package com.example.teacherstore.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.teacherstore.viewmodel.EstadoViewModel

@Composable
fun PantallaEstado(viewModel: EstadoViewModel= viewModel()){

    val estadoBoton= viewModel.activo.collectAsState()
    val estadoMensaje= viewModel.mensaje.collectAsState()

    if (estadoBoton.value == null){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center

        ){
            CircularProgressIndicator()
        }

    }else{
        val estaActivo=estadoBoton.value!!
        val durationMillis = null
        val colorAnimado by animateColorAsState(
            targetValue = if(estaActivo) Color(0xFF4CAF50) else Color(0xFFB0BEC5),
            animationSpec = tween(durationMillis=500),label=""
        )
        val textBoton by remember(estaActivo) {
            derivedStateOf { if(estaActivo) "Desactivo" else "Activar" }
        }

        Column(modifier= Modifier
            .fillMaxSize()
            .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Button(
                onClick = {viewModel::alternarEstado},
                colors = ButtonDefaults.buttonColors(containerColor = colorAnimado),
                modifier= Modifier.fillMaxSize()
                    .height(60 .dp)

            ) {
                Text(textBoton, style = MaterialTheme.typography.titleLarge)

            }
            Spacer(Modifier.height(30.dp))
            AnimatedVisibility(estadoMensaje.value) {
                Text(
                    text = "Estado guardado exitosamente",
                    color= Color.Green,
                    style= MaterialTheme.typography.bodyLarge
                )
            }
        }

    }
}