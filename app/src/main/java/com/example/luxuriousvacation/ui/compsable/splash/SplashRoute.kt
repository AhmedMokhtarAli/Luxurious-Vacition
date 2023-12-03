package com.example.luxuriousvacation.ui.compsable.splash

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.luxuriousvacation.ui.navigation.NavScreen
import com.example.luxuriousvacation.ui.utilis.HideSystemUi

fun NavGraphBuilder.splashRoute(navController: NavHostController) {
    composable(NavScreen.SplashScreen.route) {
        HideSystemUi()
        SplashScreen(navController = navController)
    }
}