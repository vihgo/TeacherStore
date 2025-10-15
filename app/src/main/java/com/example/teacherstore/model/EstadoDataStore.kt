package com.example.teacherstore.model

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private  const val PREFERENCIAS_USUARIO="preferencias_usuario"
val Context.dataStore:DataStore<Preferences> by preferencesDataStore(PREFERENCIAS_USUARIO)

class EstadoDataStore(private val context:Context){

    private val ESTADO_BOTON= booleanPreferencesKey("estado_boton")

    //escribe en el archivo de preferencias
    suspend fun guardarEstado(nuevoEstado:Boolean){
        context.dataStore.edit { preferencias ->
            preferencias[ESTADO_BOTON]=nuevoEstado
        }
    }

    //lee en el archivo de preferencias
   /* suspend fun obtenerEstado(): Flow<Boolean?>{
        return context.dataStore.data.map { preferencias ->
            preferencias[ESTADO_BOTON]
        }
    }*/
     suspend fun obtenerEstado(): Flow<Boolean?> {
        return context.dataStore.data.map { preferencias ->
            preferencias[ESTADO_BOTON]
        }
    }

}
