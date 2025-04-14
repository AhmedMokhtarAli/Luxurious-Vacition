package com.example.luxuriousvacation.ui.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.luxuriousvacation.R
import com.example.luxuriousvacation.ui.navigation.LoginScreen
import com.example.luxuriousvacation.ui.navigation.SplashScreen
import com.example.luxuriousvacation.ui.theme.Blue1
import com.example.luxuriousvacation.ui.theme.Circular
import com.example.luxuriousvacation.ui.theme.Haitus
import com.example.luxuriousvacation.ui.theme.Montserrat
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    SplashScreenContent {
        navController.navigate(LoginScreen) {
            popUpTo(SplashScreen) { inclusive = true }
        }
    }
}

@Composable
private fun SplashScreenContent(navigateToLogin: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(2000)
        navigateToLogin()
    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.splash_background),
                contentScale = ContentScale.FillBounds
            )
    ) {
        val (titleTv, descriptionTv, luxTv, exploreButton) = createRefs()
        Text(
            text = stringResource(R.string.aspan),
            textAlign = TextAlign.Center,
            fontFamily = Haitus,
            color = Color.White,
            fontSize = 116.sp,
            modifier = Modifier
                .padding(top = 64.dp)
                .constrainAs(titleTv) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Text(
            text = stringResource(id = R.string.plan_your),
            textAlign = TextAlign.Start,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            fontSize = 28.sp,
            modifier = Modifier
                .constrainAs(descriptionTv) {
                    bottom.linkTo(luxTv.top)
                    start.linkTo(exploreButton.start)
                }
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = stringResource(R.string.luxurious_vacation),
            textAlign = TextAlign.Start,
            fontFamily = Montserrat,
            color = Color.White,
            fontSize = 48.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .constrainAs(luxTv) {
                    bottom.linkTo(exploreButton.top)
                    start.linkTo(exploreButton.start)
                }
                .padding(start = 16.dp, end = 16.dp)
        )
        Button(
            onClick = {
                navigateToLogin()
            },
            modifier = Modifier
                .constrainAs(exploreButton) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(top = 16.dp, bottom = 32.dp, start = 16.dp, end = 16.dp)
                .background(Color.Transparent)
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Blue1),
        ) {
            Text(
                text = stringResource(R.string.explore),
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = Circular,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

