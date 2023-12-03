package com.example.luxuriousvacation.ui.compsable.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.data.model.City
import com.example.luxuriousvacation.R
import com.example.luxuriousvacation.ui.compsable.city.navigateToCityScreen
import com.example.luxuriousvacation.ui.theme.Black3
import com.example.luxuriousvacation.ui.theme.Blue3
import com.example.luxuriousvacation.ui.theme.Circular
import com.example.luxuriousvacation.ui.theme.Montserrat
import com.example.luxuriousvacation.ui.theme.White1

@Composable
fun HomeScreen(navController: NavHostController) {
    HomeScreenContent { cityName ->
        navController.navigateToCityScreen(cityName)
    }
}

@Composable
private fun HomeScreenContent(navigeteToCity: (cityName: String) -> Unit) {
    Column(modifier = Modifier.background(White1)) {
        Logo()
        CitiesList { cityName ->
            navigeteToCity(cityName)
        }
    }
}

@Composable
private fun Logo() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.app_logo),
            contentDescription = null,
            modifier = Modifier
                .width(136.dp)
                .height(116.dp)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CitiesList(navigeteToCity: (cityName: String) -> Unit) {
    val cities = cityList()

    LazyColumn(
        modifier = Modifier
            .background(White1)
            .padding(start = 16.dp, top = 16.dp)
    ) {
        /*item {
            Logo()
        }*/
        stickyHeader {
            Text(
                text = stringResource(R.string.popular_cities),
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = 26.sp,
                color = Color.Black,
                modifier = Modifier
                    .background(White1)
                    .fillMaxWidth()
                    .height(36.dp)
            )
        }
        /* item {
             Text(
                 text = stringResource(R.string.popular_cities),
                 fontFamily = Montserrat,
                 fontWeight = FontWeight.SemiBold,
                 fontSize = 26.sp,
                 color = Color.Black,
                 modifier = Modifier.padding(top = 64.dp, start = 16.dp)
             )
         }*/
        items(items = cities, key = { currentCity -> currentCity.reviewsNum }) {
            CityItem(city = it) {
                navigeteToCity(it.name)
            }
        }
    }
}


@Composable
private fun CityItem(city: City, navigeteToCity: () -> Unit) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 8.dp)
            .clickable {
                navigeteToCity()
            }
    ) {
        val (cityNameTv, cityImg, cityReviewsTv) = createRefs()
        Image(
            painterResource(id = city.cityImg), contentDescription = null,
            modifier = Modifier
                .clip(
                    RoundedCornerShape(16.dp)
                )
                .background(Color.Transparent)
                .width(190.dp)
                .height(150.dp)
                .constrainAs(cityImg) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
        )
        Text(
            text = city.name,
            fontSize = 14.sp,
            fontFamily = Montserrat,
            fontWeight = FontWeight.SemiBold,
            color = Black3,
            modifier = Modifier
                .constrainAs(cityNameTv) {
                    top.linkTo(cityImg.top)
                    bottom.linkTo(cityImg.bottom)
                    start.linkTo(cityImg.end)
                }
                .padding(bottom = 4.dp)
        )

        Text(
            text = city.reviewsNum.toString() + stringResource(R.string.reviews),
            fontSize = 12.sp,
            fontFamily = Circular,
            color = Blue3,
            modifier = Modifier.constrainAs(cityReviewsTv) {
                top.linkTo(cityNameTv.bottom)
                start.linkTo(cityNameTv.start)
                end.linkTo(cityNameTv.end)
            }
        )
    }
}


@Composable
private fun cityList(): List<City> {
    val cities = listOf<City>(
        City(
            stringResource(R.string.coeurdes_alpes),
            stringResource(R.string.about_city),
            R.drawable.coeurdes_alpes,
            3339
        ),
        City(
            stringResource(R.string.coeurdes_alpes),
            stringResource(R.string.about_city),
            R.drawable.city2, 371
        ),
        com.example.data.model.City(
            stringResource(R.string.coeurdes_alpes),
            stringResource(R.string.about_city),
            R.drawable.coeurdes_alpes, 336
        ),
        City(
            stringResource(R.string.coeurdes_alpes),
            stringResource(R.string.about_city),
            R.drawable.coeurdes_alpes,
            3332
        ),
        City(
            stringResource(R.string.coeurdes_alpes),
            stringResource(R.string.about_city),
            R.drawable.city2, 3561
        ),
        City(
            stringResource(R.string.coeurdes_alpes),
            stringResource(R.string.about_city),
            R.drawable.coeurdes_alpes, 3569
        ), com.example.data.model.City(
            stringResource(R.string.coeurdes_alpes),
            stringResource(R.string.about_city),
            R.drawable.coeurdes_alpes,
            333
        ),
        City(
            stringResource(R.string.coeurdes_alpes),
            stringResource(R.string.about_city),
            R.drawable.city2, 35
        ),
        City(
            stringResource(R.string.coeurdes_alpes),
            stringResource(R.string.about_city),
            R.drawable.coeurdes_alpes, 864
        ), City(
            stringResource(R.string.coeurdes_alpes),
            stringResource(R.string.about_city),
            R.drawable.coeurdes_alpes,
            3384
        ),
        City(
            stringResource(R.string.coeurdes_alpes),
            stringResource(R.string.about_city),
            R.drawable.city2, 357
        ),
        City(
            stringResource(R.string.coeurdes_alpes),
            stringResource(R.string.about_city),
            R.drawable.coeurdes_alpes, 34
        )
    )
    return cities
}