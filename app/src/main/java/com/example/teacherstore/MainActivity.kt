package com.example.teacherstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.teacherstore.navigation.AppRoute
import com.example.teacherstore.navigation.NavigationEvent
import com.example.teacherstore.ui.screens.HomeScreen
import com.example.teacherstore.ui.screens.ProfileScreen
import com.example.teacherstore.ui.screens.RegistroScreen
import com.example.teacherstore.ui.theme.TeacherStoreTheme
import com.example.teacherstore.viewmodel.MainViewModel
import com.example.teacherstore.viewmodel.UsuarioViewModel
import kotlinx.coroutines.flow.collectLatest


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TeacherStoreTheme{
                val viewModel: MainViewModel= viewModel()
                val viewModelRegistro: UsuarioViewModel=viewModel()
                val navController = rememberNavController()

                /**La función LaunchedEffect en Jetpack Compose se usa para ejecutar
                 * efectos secundarios (side effects) en un entorno seguro y
                 * gestionado por el ciclo de vida.
                 * Esencialmente, te permite ejecutar código que debe ocurrir en
                 * un momento específico, pero que no es parte directa de la composición de la
                 * interfaz de usuario (UI), como iniciar una corrutina (coroutine).
                 *
                 * Manejo de Navegación: Ejecutar un código de navegación (como ir a otra pantalla)
                 *  que se dispara por un evento de ViewModel.
                 * */
                LaunchedEffect(Unit) {

                    viewModel.navEvents.collectLatest {
                        event ->
                        when(event){
                            is NavigationEvent.NavigateTo ->{
                                navController.navigate(event.appRoute.route){
                                    /**.let { ... }: Esta es una función de alcance de Kotlin que se usa para ejecutar un
                                     * bloque de código solo si el objeto no es null.
                                     * Su propósito es ejecutar un código usando el objeto que ya existe (en este caso, el valor de event.popUpRoute).*/
                                    event.popUpRoute?.let {
                                        /*Pop: Quitar el elemento de más arriba (lo que hace el botón "Atrás").
                                          popUpTo: Quitar múltiples elementos hasta un destino específico en la pila, dándote control total sobre qué destinos se mantienen.*/

                                        //popUpTo Se utiliza con la ruta de la pantalla a la que quieres volver o eliminar hasta ese punto
                                        popUpTo(it.route){
                                            //si la opcion inclusive es true, despues de navegar a la ruta con popUpTo, elimina del registro de rutas la pantalla anterior. De esta forma solo existira en la pila la ruta actual.
                                            //por ejemoplo si despues de crear la cuenta hacemos login, podemos usar inclusive= true para eliminar de la pila todas las rutas que se usaron para crear la cuenta y hacer login.
                                            inclusive=event.inclusive

                                        }
                                        /*Si la pantalla de destino ya está en la parte superior de la pila,
                                          el sistema no crea una nueva instancia. En su lugar, simplemente la reutiliza.
                                          Usado habitualmente en barras de navegación inferiores (Bottom Navigation) para no apilar la misma pantalla una y otra vez.
                                          */
                                        launchSingleTop=event.singleTop
                                        /*Si la ruta de destino tiene un estado guardado (porque se navegó lejos de ella), esta opción lo restaura.
                                        Se usa junto con saveState*/
                                        restoreState=true
                                    }

                                }



                            }
                            is NavigationEvent.NavigateUp -> navController.navigateUp()
                            is NavigationEvent.PopBackStack -> navController.popBackStack()

                        }
                    }
                }    //finaliza el bloque LaunchedEffect, encargado de realizar la coroutina para manejar la navegación.

                Scaffold(modifier = Modifier.fillMaxSize())
                {
                    innerPadding ->
                    NavHost(
                        navController=navController,
                        startDestination = AppRoute.Register.route,
                        modifier = Modifier.padding(innerPadding)

                    ){
                        composable(AppRoute.Home.route) {
                            HomeScreen(viewModel,navController)
                        }
                        composable(AppRoute.Register.route) {
                            RegistroScreen(viewModelRegistro,navController)
                        }
                        composable(AppRoute.Profile.route) {
                            ProfileScreen(viewModel,navController)
                        }
                        composable(AppRoute.Settings.route) {
                            //SettingScreen(navController,viewModel)
                        }
                    }
                }

            }
        }
    }
}
