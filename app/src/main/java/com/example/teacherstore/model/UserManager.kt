package com.example.teacherstore.model

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow


private  const val PREFERENCIAS_USUARIO="preferencias_usuario"

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(PREFERENCIAS_USUARIO)

object UserManager {
    //Definir las claves de DataStore. Las claves deben ser del tipo correspondiete a los datos que almacenaremos
    private object  clavesPreferencias{
        val NOMBRE_USUARIO= stringPreferencesKey("nombre_usuario")
        val EMAIL_USUARIO=stringPreferencesKey("email_usuario")
        val ESTA_AUTENTICADO= booleanPreferencesKey("autenticado")
    }

    //la funcion de guardado es suspend porque DataStore usa Coroutines para operaciones asincronas

    suspend fun guardarDatos(context: Context,nombre:String,email:String,autenticado:Boolean){
        context.dataStore.edit {
            preferencias ->

            preferencias[clavesPreferencias.NOMBRE_USUARIO]=nombre
            preferencias[clavesPreferencias.EMAIL_USUARIO]=email
            preferencias[clavesPreferencias.ESTA_AUTENTICADO]=autenticado
        }

    }
    //Flujo Flow para Leer los datos del usuario
    //DataStore expone los datos a través de Kotlin Flow, permitiendo observar los cambios
    val flujoUsuario: (Context) -> Flow<Map<String, Any?>> = {
        context->
        //context.dataStore.data
    }

}