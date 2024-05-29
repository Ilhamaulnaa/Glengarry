package com.glengarry.app.presentation.shop

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.core.domain.model.ServiceItem
import com.core.domain.model.ServiceType
import com.glengarry.app.ui.component.CardItem
import com.glengarry.app.ui.textfield.SearchBarWithFilter
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.topbar.BaseTopAppBar
import kotlin.math.log

@ExperimentalMaterial3Api
@Composable
fun ShopScreen(
    modifier: Modifier = Modifier
) {

    var search by remember {
        mutableStateOf("")
    }

    val needItem = listOf(
        ServiceItem(
            id = "1",
            logo = "",
            title = "Brand Update",
            rating = 4.8,
            minPrice = 100_000.0,
            serviceType = "Fashion",
            type = ServiceType.FASHION
        ),
        ServiceItem(
            id = "2",
            logo = "",
            title = "Brand Update",
            rating = 4.5,
            minPrice = 500_000.0,
            serviceType = "Electronic",
            type = ServiceType.ELECTRONIC
        ),
        ServiceItem(
            id = "3",
            logo = "",
            title = "Brand Update",
            rating = 4.1,
            minPrice = 55_000.0,
            serviceType = "Book",
            type = ServiceType.BOOK
        ),
        ServiceItem(
            id = "4",
            logo = "",
            title = "Brand Update",
            rating = 4.5,
            minPrice = 55_000.0,
            serviceType = "Sport",
            type = ServiceType.SPORT
        ),
    )

    Scaffold(
        topBar = {
            Column {
                BaseTopAppBar(
                    title = "Shop"
                )
                SearchBarWithFilter(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .padding(bottom = 20.dp),
                    value = search,
                    onValueChanged = { search = it },
                    placeholder = "Search...",
                    onFilterClick = {}
                )
            }
        },
        modifier = modifier
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            items(items = needItem, key = { it.id }){
                CardItem(
                    needItem = it,
                    onClick = {}
                )
            }
        }

    }

}

@ExperimentalMaterial3Api
@Preview
@Composable
fun ShopScreenPreview() {
    GlengarryTheme {
        Surface {
            ShopScreen()
        }
    }
}