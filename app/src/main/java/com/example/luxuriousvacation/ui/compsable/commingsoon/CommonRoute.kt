package com.example.luxuriousvacation.ui.compsable.commingsoon

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.luxuriousvacation.ui.navigation.NavScreen

fun NavController.navigateToCommonSoonScreen(){
    navigate("${NavScreen.CommonSoonScreen.route}")
}

fun NavGraphBuilder.commonSoonRoute(navController: NavHostController) {

    composable(NavScreen.CommonSoonScreen.route) {
        CommonSoonScreen(navController)
    }
}
