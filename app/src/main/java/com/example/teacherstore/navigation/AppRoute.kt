package com.example.teacherstore.navigation

sealed class AppRoute(val route:String) {

    data object PantallaEstado: AppRoute("pantalla_estado")
    data object Home:AppRoute("home")
    data object Posts:AppRoute("posts")
    data object Register: AppRoute("register")
    data object Profile: AppRoute("profile")
    data object Settings: AppRoute("settings")

    data class Detail (val itemId:String): AppRoute("detail/{itemId}")
    {
        fun buildRoute():String{
            return route.replace("{itemId}",itemId)
        }
    }


}