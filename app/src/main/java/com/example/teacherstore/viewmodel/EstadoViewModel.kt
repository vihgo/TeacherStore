package com.example.teacherstore.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.teacherstore.model.EstadoDataStore
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EstadoViewModel (application: Application) : AndroidViewModel(application) {

    //creamos el singleton de EstadoDataStore con el contexto de la aplicación (Revisar CONTEXT de android)
    private val estadoDataStore= EstadoDataStore(application)

    //_activado maneja el estado del boton, para saber si está activado o no

    private val _activo= MutableStateFlow<Boolean?>(value = null)
    val activo: StateFlow<Boolean?> =  _activo

    private val _mensaje= MutableStateFlow<Boolean>(false)
    val mensaje: StateFlow<Boolean> = _mensaje


    init {

    }

    fun cargarEstado(){
        viewModelScope.launch {
            delay(2000L)
            _activo.value= estadoDataStore.obtenerEstado().first() ?: false

        }
    }

    fun alternarEstado(){
        viewModelScope.launch {

            //si .value es null, retornara false, el signo de exclamación alterna el booleano por su opuesto
            val nuevoValor= !(_activo.value ?: false)
            estadoDataStore.guardarEstado(nuevoValor)
            _activo.value=nuevoValor
            _mensaje.value=true
            delay(2000L)
            _mensaje.value=false

        }

    }




}