package com.example.teacherstore.ui.screens

import android.R
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.teacherstore.navigation.AppRoute
import com.example.teacherstore.viewmodel.UsuarioViewModel


@Composable
fun RegistroScreen(

    viewModel: UsuarioViewModel,
    navController: NavController
){
    val estado by viewModel.estado.collectAsState()
    Scaffold(
        containerColor = Color.White, // Set your desired background color here
        content = { paddingValues ->
            // Your content goes here
           // Text(text = "Hello, Scaffold!", modifier = androidx.compose.ui.Modifier.padding(paddingValues))

            Column(
                Modifier
                    .fillMaxSize()
                    .padding(16 .dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,


            ){
                Text(estado.nombre)
                OutlinedTextField(
                    value = estado.nombre,
                    onValueChange = viewModel::onNombreChange,
                    label = {Text("Nombre")},
                    isError = estado.errores.nombre!=null,
                    singleLine = true,
                    supportingText = {
                        estado.errores.nombre?.let{
                            Text(it, color = MaterialTheme.colorScheme.error)
                        }
                    },
                    modifier = Modifier.fillMaxWidth()


                )

                //campo para el correo
                OutlinedTextField(
                    value = estado.correo,
                    onValueChange = viewModel::onCorreoChange,
                    label = {Text("Email")},
                    isError = estado.errores.correo!=null,
                    singleLine = true,
                    supportingText = {
                        estado.errores.correo?.let{
                            Text(it, color = MaterialTheme.colorScheme.error)
                        }
                    },
                    modifier = Modifier.fillMaxWidth()


                )
                //campo contraseña

                OutlinedTextField(
                    value = estado.contrasena,
                    onValueChange = viewModel::onContrasenaChange,
                    label = {Text("Contraseña")},
                    isError = estado.errores.contrasena!=null,
                    visualTransformation = PasswordVisualTransformation(),
                    supportingText = {
                        estado.errores.contrasena?.let{
                            Text(it, color = MaterialTheme.colorScheme.error)
                        }
                    },
                    modifier = Modifier.fillMaxWidth()


                )

                OutlinedTextField(
                    value = estado.direccion,
                    onValueChange = viewModel::onDireccionChange,
                    label = {Text("Dirección")},
                    isError = estado.errores.direccion!=null,
                    singleLine = true,
                    supportingText = {
                        estado.errores.direccion?.let{
                            Text(it, color = MaterialTheme.colorScheme.error)
                        }
                    },
                    modifier = Modifier.fillMaxWidth()


                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = estado.aceptaTerminos,
                        onCheckedChange = viewModel::onAceptarTerminosChange
                    )
                    Spacer(Modifier.width(8.dp))
                    Text("Acepto los términos y condiciones")

                }
                Button(
                    onClick = {
                        if (viewModel.estaValidadoElFormulario() && estado.aceptaTerminos) {
                            //El nav controller debería ir a la pantalla de resumen
                            navController.navigate(AppRoute.Home.route)

                        }
                    },
                    modifier = Modifier.fillMaxWidth()

                ) {
                    Text("Registrar")
                }

            }

        }

    )



}