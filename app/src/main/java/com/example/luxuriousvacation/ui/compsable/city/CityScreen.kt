package com.example.luxuriousvacation.ui.compsable.city

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.luxuriousvacation.R
import com.example.luxuriousvacation.ui.theme.Abel
import com.example.luxuriousvacation.ui.theme.Black3
import com.example.luxuriousvacation.ui.theme.Black4
import com.example.luxuriousvacation.ui.theme.Blue3
import com.example.luxuriousvacation.ui.theme.Circular
import com.example.luxuriousvacation.ui.theme.Montserrat
import com.example.luxuriousvacation.ui.theme.White1

@Composable
fun CityScreen(
    navController: NavHostController,
    cityViewModel: CityViewModel = hiltViewModel()
) {
    val cityNameState by cityViewModel.cityName.collectAsState()

    CityContent(cityName = cityNameState) {
        navController.navigateUp()
    }
}

@Composable
private fun CityContent(cityName: String, navigateUp: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White1)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Back {
                navigateUp()
            }
            CityImage(cityImage = R.drawable.city2)
            CityNameAndReview(cityName = cityName, cityReview = 356)
            AboutCityText(aboutCity = stringResource(id = R.string.about_city))
        }
    }
}

@Composable
private fun Back(navigateUp: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.back),
        contentDescription = null,
        modifier = Modifier
            .clickable {
                navigateUp()
            }
            .padding(bottom = 16.dp)
    )
}

@Composable
private fun CityImage(cityImage: Int) {
    Image(
        painter = painterResource(id = R.drawable.city2),
        contentDescription = null,
        modifier = Modifier
            .clip(
                shape = RoundedCornerShape(16.dp)
            )
            .fillMaxWidth()
            .height(250.dp), contentScale = ContentScale.Crop
    )
}

@Composable
private fun CityNameAndReview(cityName: String, cityReview: Int) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = cityName,
            fontSize = 24.sp,
            fontFamily = Montserrat,
            fontWeight = FontWeight.SemiBold,
            color = Black3
        )
        Text(
            text = cityReview.toString() + "  ${stringResource(R.string.reviews)}",
            fontSize = 14.sp,
            fontFamily = Circular,
            color = Blue3,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
private fun AboutCityText(aboutCity: String) {
    Text(
        text = aboutCity,
        fontSize = 10.sp,
        fontFamily = Abel,
        fontWeight = FontWeight.Normal,
        color = Black4,
    )
}
