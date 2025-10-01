package com.example.teacherstore.viewmodel

import androidx.lifecycle.ViewModel
import com.example.teacherstore.navigation.AppRoute
import com.example.teacherstore.navigation.NavEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

/*import com.example.teacherstore.navigation.AppRoute
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch*/


class MainViewModel: ViewModel() {


    private val _navEvents= MutableSharedFlow<NavEvent>()
    val navEvents= _navEvents.asSharedFlow()

    fun navigateTo(appRoute: AppRoute){
        CoroutineScope(Dispatchers.Main).launch {
            _navEvents.emit(NavEvent.NavigateTo(appRoute))
        }
    }

    fun navigateBack(){
        CoroutineScope(Dispatchers.Main).launch {
            _navEvents.emit(NavEvent.PopBackStack)
        }
    }

    fun navigateUp(){
        CoroutineScope(Dispatchers.Main).launch {
            _navEvents.emit(NavEvent.NavigateUp)
        }
    }




}