package com.example.luxuriousvacation.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.example.luxuriousvacation.ui.compsable.home.HomeScreen
import com.example.luxuriousvacation.ui.navigation.CreateNavigationGraph
import com.example.luxuriousvacation.ui.theme.LuxuriousVacationTheme
import com.example.luxuriousvacation.ui.utilis.SetStatusBarColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            WindowCompat.setDecorFitsSystemWindows(window,true)
            LuxuriousVacationTheme {
                SetStatusBarColor(statusBarColor = Color.Transparent)
                CreateNavigationGraph()
            }
        }
    }

  
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LuxuriousVacationTheme {
        HomeScreen (rememberNavController())
    }

}
