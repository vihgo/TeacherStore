package com.example.teacherstore.model

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


private  const val PREFERENCIAS_USUARIO="preferencias_usuario"

/*val Context.dataStore: DataStore<Preferences> by preferencesDataStore(PREFERENCIAS_USUARIO)

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
        //data es un Flow<Preferences> que emite las preferencias actuales.
        context.dataStore.data
            //map transforma el objeto Preferences en un Mapa(SIMILAR A DATA CLASS)
            .map {
                preferencias->
                mapOf(
                    "nombre" to preferencias[clavesPreferencias.NOMBRE_USUARIO],
                    "email" to preferencias[clavesPreferencias.EMAIL_USUARIO],
                    "autenticado" to preferencias[clavesPreferencias.ESTA_AUTENTICADO]
                )
            }
        //data es un Flow<Preferences> que emite las preferencias actuales
        //context.dataStore.data
    }

}*/