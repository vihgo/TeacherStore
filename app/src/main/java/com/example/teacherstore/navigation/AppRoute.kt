package com.example.teacherstore.navigation

//declaramos un conjunto cerrado y seguro de rutas
sealed class AppRoute(val route:String) {//cada objeto dentro de la sealed class representa una ruta
    data object Home : AppRoute("home")
    data object Library : AppRoute("library")
    data object Profile: AppRoute("profile")

    //Tarea crear una ruta con argumentos para pantallas de detalles, por ejemplo el detalle de un producto


}