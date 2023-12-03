package com.example.luxuriousvacation.ui.compsable.login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.luxuriousvacation.ui.navigation.NavScreen
import com.example.luxuriousvacation.ui.utilis.ShowSystemUi

fun NavController.navigateToLogin(){
    navigate(NavScreen.LoginScreen.route){
        popUpTo(NavScreen.SplashScreen.route){
            inclusive = true
        }
    }
}
fun NavGraphBuilder.loginRoute(navController: NavHostController) {
    composable(NavScreen.LoginScreen.route) {
        ShowSystemUi()
        LoginScreen(navController)
    }
}