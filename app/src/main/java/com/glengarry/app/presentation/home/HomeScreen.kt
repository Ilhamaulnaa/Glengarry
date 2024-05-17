package com.glengarry.app.presentation.home

import android.graphics.Paint.Align
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.R
import com.glengarry.app.presentation.home.component.HomeCarousel
import com.glengarry.app.presentation.home.component.HomeHeader
import com.glengarry.app.presentation.home.component.HomeMenu
import com.glengarry.app.presentation.home.domain.CarouselItem
import com.glengarry.app.presentation.home.domain.MenuItem
import com.glengarry.app.presentation.home.domain.Profile
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme

@ExperimentalFoundationApi
@Composable
fun HomeScreen() {

    var profile by remember {
        mutableStateOf(Profile())
    }

    var texts = listOf(
        "Search Fashion! 💜", "Electronic... 👋", "Search All Your Needs...🥳"
    )

    val carouselItems = (1..3).map {
        CarouselItem(
            id = it,
            title = "WEAR THE REAL\n" +
                    "FASHION"
        )
    }

    val menuItems = listOf(
        MenuItem(icon = R.drawable.logo_fashion, label = R.string.label_fashion),
        MenuItem(icon = R.drawable.logo_electronic, label = R.string.label_electronic),
        MenuItem(icon = R.drawable.logo_book, label = R.string.label_book),
        MenuItem(icon = R.drawable.logo_sport, label = R.string.label_sport)
    )

    val onMenuClick: (MenuItem) -> Unit = {}

    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HomeHeader(
            modifier = Modifier.fillMaxWidth(),
            user = profile.name,
            onSearchBarClick = {},
            texts = texts
        )
        Spacer(modifier = Modifier.height(16.dp))
        HomeCarousel(
            carouselItem = carouselItems,
            onClick = {},
        )
        Spacer(modifier = Modifier.height(16.dp))
        HomeMenu(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 36.dp),
            menuItems = menuItems,
            onClick = onMenuClick
        )
        Spacer(modifier = Modifier.height(16.dp))
        BaseText(
            text = "Go Find Your Need! 🔥",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = 20.dp
            )
        )
    }

}

@ExperimentalFoundationApi
@Preview
@Composable
fun HomeScreenPreview() {
    GlengarryTheme {
        Surface {
            HomeScreen()
        }
    }
}