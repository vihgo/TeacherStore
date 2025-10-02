package com.example.teacherstore.navigation

//enumeramos los tipos de eventos que podemos emitir o observar

sealed class  NavigationEvent{
    data class NavigateTo(
        val appRoute: AppRoute,
        val popUpRoute: AppRoute?=null,
        val inclusive:Boolean=false,
        val singleTop: Boolean=false

        ): NavigationEvent()

    object PopBackStack: NavigationEvent()
    object NavigateUp: NavigationEvent()

}

