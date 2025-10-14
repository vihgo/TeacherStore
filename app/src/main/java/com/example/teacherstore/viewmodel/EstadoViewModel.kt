package com.example.teacherstore.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.teacherstore.model.EstadoDataStore

class EstadoViewModel (application: Application) : AndroidViewModel(application){

    private val estadoDataStore= EstadoDataStore(application)

}