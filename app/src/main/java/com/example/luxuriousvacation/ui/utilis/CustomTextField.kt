package com.example.luxuriousvacation.ui.utilis

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.luxuriousvacation.ui.theme.Gray1
import com.example.luxuriousvacation.ui.theme.Inter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputItem(hint: String, painterId: Int? = null) {
    val textState = remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(
            modifier = Modifier.padding(bottom = 4.dp),
            text = hint,
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            fontSize = 14.sp
        )
        TextField(
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
                .background(Color.Transparent)
                .shadow(2.dp, shape = RoundedCornerShape(16.dp)),
            value = textState.value,
            onValueChange = { newText ->
                textState.value = newText
            },
            placeholder = {
                Text(
                    hint, fontSize = 14.sp, fontFamily = Inter,
                    fontWeight = FontWeight.Normal, color = Gray1
                )
            },
            colors = TextFieldDefaults.textFieldColors(/*backgroundColor = Color.White,*/
                containerColor = Color.White,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                textColor = Color.Black
            ), trailingIcon = {
                painterId?.let {
                    Icon(painter = painterResource(id = painterId), contentDescription = null)
                }
            }
        )
    }
}

