package com.example.luxuriousvacation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.luxuriousvacation.ui.screens.commingsoon.CommonSoonScreen
import com.example.luxuriousvacation.ui.screens.login.LoginScreen
import com.example.luxuriousvacation.ui.screens.signup.SignupScreen
import com.example.luxuriousvacation.ui.screens.splash.SplashScreen
import com.example.luxuriousvacation.ui.screens.terms.TermsAndConditionsScreen

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = SplashScreen) {
        composable<SplashScreen> {
            SplashScreen(navController)
        }
        composable<LoginScreen> {
            LoginScreen(navController)
        }
        composable<SignupScreen> {
            SignupScreen(navController)
        }
        composable<Terms> {
            TermsAndConditionsScreen()
        }
        composable<CommonSoon> {
            CommonSoonScreen(navController)
        }
    }
}
