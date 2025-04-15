package com.example.luxuriousvacation.ui.utilis

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.luxuriousvacation.ui.theme.Gray1
import com.example.luxuriousvacation.ui.theme.Inter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputItem(
    value: String = "",
    hint: String,
    painterId: Int? = null,
    isPassword: Boolean = false,
    isNumberOnly: Boolean = false,
    errorResId: Int? = null,
    onValueChange: (String) -> Unit,
) {
    var passwordVisible by remember { mutableStateOf(false) }

    val keyboardOptions = when {
        isNumberOnly -> KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        isPassword -> KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password)
        else -> KeyboardOptions.Default
    }

    val visualTransformation = if (isPassword && !passwordVisible) {
        PasswordVisualTransformation()
    } else {
        VisualTransformation.None
    }

    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(
            text = hint,
            modifier = Modifier.padding(bottom = 4.dp),
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            fontSize = 14.sp
        )

        TextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = hint,
                    fontSize = 14.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal,
                    color = Gray1
                )
            },
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            isError = errorResId != null,
            trailingIcon = {
                Row {
                    if (isPassword) {
                        val icon = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(imageVector = icon, contentDescription = "Toggle Password Visibility")
                        }
                    } else if (painterId != null) {
                        Icon(
                            painter = painterResource(id = painterId),
                            contentDescription = null
                        )
                    }
                }
            },
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
                .shadow(2.dp, shape = RoundedCornerShape(16.dp))
                .background(Color.Transparent),
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                textColor = Color.Black,
                errorLabelColor = Color.Red
            )
        )
        if (errorResId != null) {
            Text(
                text = stringResource(errorResId) ,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 8.dp, top = 4.dp)
            )
        }
    }
}

