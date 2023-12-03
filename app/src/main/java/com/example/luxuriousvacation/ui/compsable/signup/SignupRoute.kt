package com.example.luxuriousvacation.ui.compsable.signup

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.luxuriousvacation.ui.compsable.login.LoginScreen
import com.example.luxuriousvacation.ui.navigation.NavScreen
import com.example.luxuriousvacation.ui.utilis.ShowSystemUi


fun NavController.navigateToSignup(){
    navigate(NavScreen.SignUpScreen.route)
}
fun NavGraphBuilder.signupRoute(navController: NavHostController) {
    composable(NavScreen.SignUpScreen.route) {
        SignupScreen(navController = navController)
    }
}