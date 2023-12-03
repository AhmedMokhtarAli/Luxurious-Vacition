package com.example.luxuriousvacation.ui.utilis

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun SetStatusBarColor(statusBarColor: Color) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(color = statusBarColor,darkIcons = true)
    }
}


@Composable
fun HideSystemUi() {
    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.isStatusBarVisible = false // Status bar
    systemUiController.isNavigationBarVisible = false // Navigation bar
    systemUiController.isSystemBarsVisible = false // Status & Navigation bars
}

@Composable
fun ShowSystemUi() {
    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.isStatusBarVisible = true // Status bar
    systemUiController.isNavigationBarVisible = true // Navigation bar
    systemUiController.isSystemBarsVisible = true // Status & Navigation bars
}
