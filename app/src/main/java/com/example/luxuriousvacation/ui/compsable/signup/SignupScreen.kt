package com.example.luxuriousvacation.ui.compsable.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
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
import com.example.luxuriousvacation.ui.compsable.login.navigateToLogin
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
fun SignupScreen(navController: NavHostController) {
    SignUpContent(navigateUp = {
        navController.navigateUp()
    }, navigateToHome = {
        navController.navigateToHome()
    }, navigateToLogin = {
        navController.navigateToLogin()
    })
}

@Composable
private fun SignUpContent(navigateUp: () -> Unit, navigateToHome: () -> Unit, navigateToLogin: () -> Unit) {
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
            LogoAndBackarrow {
                navigateUp()
            }
            VerticalSpacer(32)
            Titles()
            TextInputItem(hint = stringResource(R.string.phone_number))
            TextInputItem(hint = stringResource(R.string.email))
            TextInputItem(hint = stringResource(R.string.city))
            TextInputItem(hint = stringResource(R.string.password), painterId = R.drawable.eye)
            TermsAndCondition()
            SignUpButton {
                navigateToHome()
            }
            AlreadyHaveAccount {
                navigateToLogin()
            }
        }
    }
}

@Composable
private fun LogoAndBackarrow(navigateUp: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth(), Arrangement.spacedBy(110.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.arrow_left),
            contentDescription = null,
            modifier = Modifier
                .width(32.dp)
                .height(32.dp)
                .clickable { navigateUp() })
        Image(
            painter = painterResource(id = R.drawable.app_logo),
            contentDescription = null
        )

    }
}

@Composable
private fun Titles() {
    Column(
        modifier = Modifier.padding(bottom = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(R.string.sign_up),
            fontSize = 36.sp,
            fontFamily = Inter,
            color = Black1,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = stringResource(R.string.create_your_personal_profile_com_and_follow),
            fontSize = 12.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Light,
            color = Black2,
            maxLines = 1

        )
    }
}

@Composable
private fun TermsAndCondition() {
    val checkedState = remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
            colors = CheckboxDefaults.colors(uncheckedColor = Blue2, checkedColor = Blue2)
        )
        ClickableText(modifier = Modifier.padding(vertical = 8.dp), text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    Black,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium
                )
            ) {
                append(stringResource(R.string.by_signing_up_you_agree_to_the))

            }
            withStyle(
                style = SpanStyle(
                    Blue2,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium
                )
            ) {
                append(stringResource(R.string.terms_of_service_and_privacy_policy))
            }
        }, onClick = {

        })
    }
}

@Composable
private fun SignUpButton(navigataeToHome: () -> Unit) {
    Button(
        onClick = { navigataeToHome() },
        modifier = Modifier
            .padding(top = 48.dp)
            .background(Transparent)
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Blue1),
    ) {
        Text(
            text = stringResource(R.string.sign_up),
            color = Color.White,
            fontSize = 16.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun AlreadyHaveAccount(navigateToLogin: () -> Unit) {
    ClickableText(modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center),text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                Gray2,
                fontFamily = Inter,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )
        ) {
            append(stringResource(R.string.already_have_an_account))

        }
        withStyle(
            style = SpanStyle(
                Blue2,
                fontFamily = Inter,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline)
        ) {
            append(stringResource(R.string.login))
        }
    }, onClick = { navigateToLogin() }
    )
}