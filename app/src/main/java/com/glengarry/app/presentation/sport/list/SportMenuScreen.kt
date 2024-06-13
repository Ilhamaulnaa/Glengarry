package com.glengarry.app.presentation.sport.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.core.domain.model.ServiceItem
import com.core.domain.model.ServiceType
import com.glengarry.app.ui.component.CardItem
import com.glengarry.app.ui.textfield.SearchBarWithFilter
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.topbar.DetailTopAppBar

@ExperimentalLayoutApi
@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
@Composable
fun SportMenuScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit = {},
    query: String = "",
    onQueryChange: (String) -> Unit = {},
    needItem: List<ServiceItem> = emptyList(),
    onFilterClick: () -> Unit = {},
    texts: List<String> = emptyList(),
    navigateToDetailFashionScreen: () -> Unit = {}
) {
    
    val scrollState = rememberScrollState()

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
            serviceType = "Sport",
            type = ServiceType.SPORT
        ),
        ServiceItem(
            id = "3",
            logo = "",
            title = "Brand Update",
            rating = 4.4,
            minPrice = 100_000.00,
            serviceType = "Sport",
            type = ServiceType.SPORT
        ),
        ServiceItem(
            id = "4",
            logo = "",
            title = "Brand Update",
            rating = 4.2,
            minPrice = 730_000.00,
            serviceType = "Sport",
            type = ServiceType.SPORT
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
            serviceType = "Sport",
            type = ServiceType.SPORT
        ),
        ServiceItem(
            id = "7",
            logo = "",
            title = "Brand Update",
            rating = 4.0,
            minPrice = 56_000.00,
            serviceType = "Sport",
            type = ServiceType.SPORT
        ),
        ServiceItem(
            id = "8",
            logo = "",
            title = "Brand Update",
            rating = 4.7,
            minPrice = 56_000.00,
            serviceType = "Sport",
            type = ServiceType.SPORT
        ),

    )

    val onItemClick: (ServiceItem) -> Unit = {
        navigateToDetailFashionScreen()
    }

    Scaffold(
        topBar = {
            Column(
            ) {
                DetailTopAppBar(
                    title = "Sport",
                    onNavigationClick = navigateUp
                )
                Spacer(modifier = Modifier.height(8.dp))
                SearchBarWithFilter(
                    value = query,
                    onValueChanged = onQueryChange,
                    texts = texts,
                    placeholder = "Search Sport",
                    onFilterClick = onFilterClick,
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .padding(bottom = 16.dp)
                )
            }
        },
        modifier = modifier
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ){
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
                        onClick = onItemClick
                    )
                }
            }
//            AnimatedVisibility(
//                visible = true,
//                enter = fadeIn(),
//                exit = fadeOut()
//            ) {
//                LazyVerticalStaggeredGrid(
//                    columns = StaggeredGridCells.Fixed(2),
//                    verticalItemSpacing = 8.dp,
//                    horizontalArrangement = Arrangement.spacedBy(8.dp),
//                    contentPadding = PaddingValues(vertical = 8.dp, horizontal = 20.dp)
//                ){
//                    items(needItem.size){
//                        CardItem(
//                            needItem = needItem,
//                            modifier = Modifier.weight(1f),
//                            onClick = onItemClick
//                        )
//                    }
//                }
//            }
        }

    }

}

@ExperimentalLayoutApi
@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
@Preview
@Composable
fun SportMenuScreenPreview() {
    GlengarryTheme {
        Surface {
            SportMenuScreen()
        }
    }
}