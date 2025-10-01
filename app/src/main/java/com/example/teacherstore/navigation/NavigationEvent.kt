package com.example.teacherstore.navigation

sealed class NavigationEvent {
    data class NavigationTo(val appRoute: AppRoute,
        val popUpAppRoute:AppRoute?=null,
        val inclusive: Boolean=false,
        val singleTop: Boolean=false
    ): NavigationEvent()


    object  PopBackStack: NavigationEvent()
    object NavigateUp: NavigationEvent()
}

