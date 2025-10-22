package com.example.teacherstore.model

//creamos una lista para

//Este modelo de datos será actualizado por el viewmodel
data class UsuarioUiState(
    val nombre: String="",
    val correo: String="",
    val contrasena: String="",
    val direccion: String="",
    val aceptaTerminos: Boolean=false,
    val errores: UsuarioErrores= UsuarioErrores()

)

data class UsuarioErrores(
    val nombre: String?=null,
    val correo: String?=null,
    val contrasena: String?=null,
    val direccion: String? =null
)


