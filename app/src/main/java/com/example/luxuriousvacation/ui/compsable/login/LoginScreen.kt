package com.example.luxuriousvacation.ui.compsable.login


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.luxuriousvacation.R
import com.example.luxuriousvacation.ui.compsable.home.navigateToHome
import com.example.luxuriousvacation.ui.compsable.signup.navigateToSignup
import com.example.luxuriousvacation.ui.navigation.NavScreen
import com.example.luxuriousvacation.ui.theme.Black1
import com.example.luxuriousvacation.ui.theme.Black2
import com.example.luxuriousvacation.ui.theme.Blue1
import com.example.luxuriousvacation.ui.theme.Blue2
import com.example.luxuriousvacation.ui.theme.Gray2
import com.example.luxuriousvacation.ui.theme.Inter
import com.example.luxuriousvacation.ui.theme.White1
import com.example.luxuriousvacation.ui.utilis.TextInputItem
import com.example.luxuriousvacation.ui.utilis.VerticalSpacer

@Composable
fun LoginScreen(navController: NavHostController) {
    LoginContent(
        navigateToHome = { navController.navigateToHome() },
        navigateToSignUp = { navController.navigateToSignup() }
    )
}

@Composable
private fun LoginContent(navigateToHome: () -> Unit, navigateToSignUp: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White1)
    ) {
        Column(
            Modifier
                .padding(vertical = 32.dp, horizontal = 16.dp)
                .fillMaxSize()
        ) {
            Logo()
            VerticalSpacer(32)
            Titles()
            TextInputItem(hint = stringResource(R.string.phone_number))
            TextInputItem(hint = stringResource(R.string.password))
            LoginButton {
                navigateToHome()
            }
            DontHaveAnAccount {
                navigateToSignUp()
            }
        }
    }
}

@Composable
private fun Logo() {
    Image(
        painter = painterResource(id = R.drawable.app_logo),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}

@Composable
private fun Titles() {
    Column(
        modifier = Modifier.padding(bottom = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(R.string.login),
            fontSize = 36.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.SemiBold,
            color = Black1
        )
        Text(
            text = stringResource(R.string.enter_to_your_personal_profile_com_and_follow),
            fontSize = 12.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Light,
            color = Black2,
            maxLines = 1

        )
    }
}

@Composable
private fun LoginButton(navigateToHome: () -> Unit) {
    Button(
        onClick = {
            navigateToHome()
        },
        modifier = Modifier
            .padding(vertical = 48.dp, horizontal = 16.dp)
            .background(Transparent)
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Blue1),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = stringResource(R.string.login),
            color = Color.White,
            fontSize = 16.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun DontHaveAnAccount(navigateToSignUp: () -> Unit) {
    ClickableText(modifier = Modifier
        .padding(top = 8.dp)
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center), text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                Gray2,
                fontFamily = Inter,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )
        ) {
            append(stringResource(R.string.don_t_have_an_account_yet))
        }
        withStyle(
            style = SpanStyle(
                Blue2,
                fontFamily = Inter,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append(stringResource(R.string.sign_up))
        }
    }, onClick = { navigateToSignUp() })
}