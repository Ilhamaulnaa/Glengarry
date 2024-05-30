package com.glengarry.app.presentation.home

import android.graphics.Paint.Align
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.core.domain.model.Resource
import com.core.domain.model.ServiceItem
import com.core.domain.model.ServiceType
import com.glengarry.app.R
import com.glengarry.app.presentation.home.component.HomeCarousel
import com.glengarry.app.presentation.home.component.HomeHeader
import com.glengarry.app.presentation.home.component.HomeMenu
import com.glengarry.app.presentation.home.domain.CarouselItem
import com.glengarry.app.presentation.home.domain.MenuItem
import com.glengarry.app.presentation.home.domain.Profile
import com.glengarry.app.ui.button.TertiaryButton
import com.glengarry.app.ui.component.CardItem
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.textfield.SearchBarWithFilter
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.topbar.BaseTopAppBar

@ExperimentalMaterial3Api
@ExperimentalLayoutApi
@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

    val scrollState = rememberScrollState()

    var search by remember {
        mutableStateOf("")
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

//    val numbers = (1..6).toList()
    val needItem = listOf(
        ServiceItem(
            id = "1",
            logo = "",
            title = "Brand Update",
            rating = 4.0,
            minPrice = 250_000.00,
            serviceType = "Sport",
            type = ServiceType.SPORT
        ),
        ServiceItem(
            id = "2",
            logo = "",
            title = "Brand Update",
            rating = 4.9,
            minPrice = 150_000.00,
            serviceType = "Fashion",
            type = ServiceType.FASHION
        ),
        ServiceItem(
            id = "3",
            logo = "",
            title = "Brand Update",
            rating = 4.4,
            minPrice = 100_000.00,
            serviceType = "Fashion",
            type = ServiceType.FASHION
        ),
        ServiceItem(
            id = "4",
            logo = "",
            title = "Brand Update",
            rating = 4.2,
            minPrice = 730_000.00,
            serviceType = "Electronic",
            type = ServiceType.ELECTRONIC
        ),
        ServiceItem(
            id = "5",
            logo = "",
            title = "Brand Update",
            rating = 4.4,
            minPrice = 100_000.00,
            serviceType = "Sport",
            type = ServiceType.SPORT
        ),
        ServiceItem(
            id = "6",
            logo = "",
            title = "Brand Update",
            rating = 4.8,
            minPrice = 56_000.00,
            serviceType = "Book",
            type = ServiceType.BOOK
        ),
        ServiceItem(
            id = "7",
            logo = "",
            title = "Brand Update",
            rating = 4.0,
            minPrice = 56_000.00,
            serviceType = "Electronic",
            type = ServiceType.ELECTRONIC
        ),
        ServiceItem(
            id = "8",
            logo = "",
            title = "Brand Update",
            rating = 4.7,
            minPrice = 56_000.00,
            serviceType = "Fashion",
            type = ServiceType.FASHION
        ),

    )

    val onMenuClick: (MenuItem) -> Unit = {}

    Scaffold(
        topBar = {
            Column {
                BaseText(
                    text = "DISCOVER",
                    fontSize = 32.sp,
                    color = Color(0xFF080020),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(horizontal = 20.dp)
                )
                SearchBarWithFilter(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp),
                    value = search,
                    texts = texts,
                    onValueChanged = { search = it },
                    placeholder = "Search...",
                    onFilterClick = {}
                )
            }
        },
        modifier = modifier
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
                    .padding(
                        horizontal = 20.dp
                    )
            )
            Spacer(modifier = Modifier.height(16.dp))
            FlowRow(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                maxItemsInEachRow = 2
            ){
                for (needItem in needItem){
                    CardItem(
                        needItem = needItem,
                        modifier = Modifier.weight(1f),
                        onClick = {}
                    )
                }
            }
//        FlowRow(
//            modifier = Modifier.padding(horizontal = 20.dp).fillMaxWidth(),
//            horizontalArrangement = Arrangement.spacedBy(8.dp),
//            verticalArrangement = Arrangement.spacedBy(8.dp),
//            maxItemsInEachRow = 2
//        ) {
//            CardItem(
//            needItem = needItem,
//            onClick = {},
//            modifier = Modifier.weight(1f)
//            )
//        }
            Spacer(modifier = Modifier.height(16.dp))
            TertiaryButton(
                text = "See All",
                onClick = {},
            )
            Spacer(modifier = Modifier.height(60.dp))
        }
    }

}

@ExperimentalMaterial3Api
@ExperimentalLayoutApi
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