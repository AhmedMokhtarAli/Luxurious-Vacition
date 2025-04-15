package com.example.luxuriousvacation.ui.screens.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
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
import com.example.luxuriousvacation.ui.navigation.CommonSoon
import com.example.luxuriousvacation.ui.navigation.LoginScreen
import com.example.luxuriousvacation.ui.navigation.Terms
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
    SignUpContent(
        onBack = { navController.navigateUp() },
        onSignUp = { navController.navigate(CommonSoon) },
        onLogin = { navController.navigate(LoginScreen) },
        onTermsClick = { navController.navigate(Terms) }
    )
}

@Composable
private fun SignUpContent(
    onBack: () -> Unit,
    onSignUp: () -> Unit,
    onLogin: () -> Unit,
    onTermsClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White1)
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 16.dp)
                .fillMaxSize()
        ) {
            HeaderWithLogo(onBack = onBack)
            VerticalSpacer(32)
            SignupTitles()
            TextInputItem(
                hint = stringResource(R.string.phone_number),
                isNumberOnly = true,
                onValueChange = {}
            )
            TextInputItem(hint = stringResource(R.string.email), onValueChange = {})
            TextInputItem(hint = stringResource(R.string.city), onValueChange = {})
            TextInputItem(
                hint = stringResource(R.string.password),
                isPassword = true,
                onValueChange = {}

            )
            TermsAndConditions(onTermsClick)
            SignUpButton(onClick = onSignUp)
            LoginRedirect(onLogin = onLogin)
        }
    }
}


@Composable
private fun HeaderWithLogo(onBack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(64.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.arrow_left),
            contentDescription = "Back",
            modifier = Modifier
                .size(32.dp)
                .align(Alignment.CenterStart)
                .clickable { onBack() }
        )
        Image(
            painter = painterResource(id = R.drawable.app_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(64.dp)
                .align(Alignment.Center)
        )
    }
}

@Composable
private fun SignupTitles() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = stringResource(R.string.sign_up),
            fontSize = 36.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.SemiBold,
            color = Black1
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
private fun TermsAndConditions(onTermsClick: () -> Unit) {
    val checkedState = remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
            colors = CheckboxDefaults.colors(
                uncheckedColor = Blue2,
                checkedColor = Blue2
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        ClickableText(
            text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        color = Black,
                        fontFamily = Inter,
                        fontWeight = FontWeight.Medium
                    )
                ) {
                    append(stringResource(R.string.by_signing_up_you_agree_to_the))
                }
                withStyle(
                    SpanStyle(
                        color = Blue2,
                        fontFamily = Inter,
                        fontWeight = FontWeight.Medium
                    )
                ) {
                    append(" ")
                    append(stringResource(R.string.terms_of_service_and_privacy_policy))
                }
            },
            onClick = { onTermsClick() }
        )
    }
}

@Composable
private fun SignUpButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(top = 48.dp)
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Blue1),
        shape = RoundedCornerShape(8.dp)
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
private fun LoginRedirect(onLogin: () -> Unit) {
    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .wrapContentSize(Alignment.Center),
        text = buildAnnotatedString {
            withStyle(
                SpanStyle(
                    color = Gray2,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            ) {
                append(stringResource(R.string.already_have_an_account))
            }
            withStyle(
                SpanStyle(
                    color = Blue2,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append(" ")
                append(stringResource(R.string.login))
            }
        },
        onClick = { onLogin() }
    )
}
