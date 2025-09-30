package com.example.teacherstore.navigation

//enumeramos los tipos de eventos que podemos emitir o observar

sealed interface NavEvent{
    data class  To(val route:String): NavEvent
    data object Back: NavEvent
}