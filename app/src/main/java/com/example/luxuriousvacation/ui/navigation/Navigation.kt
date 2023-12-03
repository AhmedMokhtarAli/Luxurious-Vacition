package com.example.luxuriousvacation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.luxuriousvacation.ui.compsable.city.cityRoute
import com.example.luxuriousvacation.ui.compsable.commingsoon.CommonSoonScreen
import com.example.luxuriousvacation.ui.compsable.commingsoon.commonSoonRoute
import com.example.luxuriousvacation.ui.compsable.login.LoginScreen
import com.example.luxuriousvacation.ui.compsable.home.HomeScreen
import com.example.luxuriousvacation.ui.compsable.home.homeRoute
import com.example.luxuriousvacation.ui.compsable.login.loginRoute
import com.example.luxuriousvacation.ui.compsable.signup.SignupScreen
import com.example.luxuriousvacation.ui.compsable.signup.signupRoute
import com.example.luxuriousvacation.ui.compsable.splash.SplashScreen
import com.example.luxuriousvacation.ui.compsable.splash.splashRoute
import com.example.luxuriousvacation.ui.utilis.HideSystemUi
import com.example.luxuriousvacation.ui.utilis.ShowSystemUi

@Composable
fun CreateNavigationGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavScreen.SplashScreen.route) {
        splashRoute(navController)
        loginRoute(navController)
        signupRoute(navController)
        homeRoute(navController)
        cityRoute(navController)
        commonSoonRoute(navController)
    }
}


sealed class NavScreen(val route: String) {
    object SplashScreen : NavScreen("splash_screen")
    object LoginScreen : NavScreen("login_screen")
    object SignUpScreen : NavScreen("signup_screen")

    object HomeScreen : NavScreen("home_screen")

    object CityScreen : NavScreen("city_screen")
    object CommonSoonScreen : NavScreen("common_soon")
}