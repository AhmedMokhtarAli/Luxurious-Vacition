package com.example.luxuriousvacation.ui.compsable.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.luxuriousvacation.ui.navigation.NavScreen

fun NavController.navigateToHome(){
    navigate(NavScreen.HomeScreen.route)
}
fun NavGraphBuilder.homeRoute(navController: NavHostController){
    composable(NavScreen.HomeScreen.route){
        HomeScreen(navController = navController)
    }
}