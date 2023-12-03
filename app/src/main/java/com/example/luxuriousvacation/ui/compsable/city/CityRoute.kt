package com.example.luxuriousvacation.ui.compsable.city

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.luxuriousvacation.ui.navigation.NavScreen

fun NavController.navigateToCityScreen(name:String){
    navigate("${NavScreen.CityScreen.route}/${name}")
}

fun NavGraphBuilder.cityRoute(navController: NavHostController) {

    composable(
        "${NavScreen.CityScreen.route}/{${CityNavArgs.NAME_ARG}}",
        arguments = listOf(navArgument(CityNavArgs.NAME_ARG) { NavType.StringType })
    ) {
        CityScreen(navController)
    }
}

class CityNavArgs(private val savedStateHandle: SavedStateHandle) {

    val name: String = checkNotNull(savedStateHandle[NAME_ARG])

    companion object {
        const val NAME_ARG = "name"
    }
}