package com.glengarry.app.presentation.home

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Surface
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.core.domain.model.ServiceItem
import com.core.domain.model.ServiceType
import com.glengarry.app.R
import com.glengarry.app.presentation.home.component.HomeCarousel
import com.glengarry.app.presentation.home.component.HomeMenu
import com.glengarry.app.presentation.home.domain.CarouselItem
import com.glengarry.app.presentation.home.domain.MenuItem
import com.glengarry.app.ui.buttomsheet.ChipFilterType
import com.glengarry.app.ui.buttomsheet.FilterBottomSheetHeader
import com.glengarry.app.ui.buttomsheet.MultipleChipFilter
import com.glengarry.app.ui.buttomsheet.SingleChipFilter
import com.glengarry.app.ui.button.TertiaryButton
import com.glengarry.app.ui.component.CardItem
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.textfield.SearchBarWithFilter
import com.glengarry.app.ui.theme.GlengarryTheme
import kotlinx.coroutines.launch

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@ExperimentalLayoutApi
@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToDetailFashionScreen: () -> Unit = {},
    navigateToDetailElectronicScreen: () -> Unit = {},
    navigateToDetailBookScreen: () -> Unit = {},
    navigateToDetailSportScreen: () -> Unit = {},
    navigateToFashionMenuScreen: () -> Unit = {},
    navigateToElectronicMenuScreen: () -> Unit = {},
    navigateToBookMenuScreen: () -> Unit = {},
    navigateToSportMenuScreen: () -> Unit = {},

) {

    val state = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true
    )

    val scope = rememberCoroutineScope()
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

    val categoryFilter = listOf(
        "Fashion",
        "Electronic",
        "Book",
        "Sport"
    )
    var selectedCategoryFilter by remember {
        mutableStateOf("")
    }

    val subCategoryFilter = listOf(
        "Hoodie",
        "Levis",
        "Hat",
        "T-shirt",
        "Shoes"
    )
    val selectedSubCategoryFilter = remember {
        mutableStateListOf<String>()
    }

    val type = remember(key1 = selectedCategoryFilter) {
        when(selectedCategoryFilter){
            "Fashion" -> ChipFilterType.FASHION
            "Electronic" -> ChipFilterType.ELECTRONIC
            "Book" -> ChipFilterType.BOOK
            else -> ChipFilterType.SPORT
        }
    }

    val menuItems = listOf(
        MenuItem(icon = R.drawable.logo_fashion, label = R.string.label_fashion),
        MenuItem(icon = R.drawable.logo_electronic, label = R.string.label_electronic),
        MenuItem(icon = R.drawable.logo_book, label = R.string.label_book),
        MenuItem(icon = R.drawable.logo_sport, label = R.string.label_sport)
    )

    val onMenuClick: (MenuItem) -> Unit = { menu ->
        when(menu.label){
            R.string.label_fashion -> navigateToFashionMenuScreen()
            R.string.label_electronic -> navigateToElectronicMenuScreen()
            R.string.label_book -> navigateToBookMenuScreen()
            R.string.label_sport -> navigateToSportMenuScreen()
        }

    }

    val onResetFilterClick: () -> Unit = {
        selectedCategoryFilter = ""
        selectedSubCategoryFilter.clear()
    }

    val onCategoryChanged: (String) -> Unit = {
        selectedCategoryFilter = it
        selectedSubCategoryFilter.clear()
    }

    val onSubcategoryFilter: (String) -> Unit = {
        val contains = selectedSubCategoryFilter.contains(it)
        if (contains){
            selectedSubCategoryFilter.remove(it)
        }else{
            selectedSubCategoryFilter.add(it)
        }
    }

    val showFilterDialog: () -> Unit = {
        scope.launch {
            state.show()
        }
    }

    val onSearchAndFilterClick: (String) -> Unit = {
        scope.launch {
            state.hide()
        }
        val serviceType = when(selectedCategoryFilter){
            categoryFilter[0] -> "Fashion"
            categoryFilter[1] -> "Electronic"
            categoryFilter[2] -> "Book"
            categoryFilter[3] -> "Sport"
            else -> ""
        }
    }

    val onItemClick: (ServiceItem) -> Unit = {
        when (it.type) {
            ServiceType.ALL -> navigateToDetailFashionScreen()
            ServiceType.FASHION -> navigateToDetailFashionScreen()
            ServiceType.ELECTRONIC -> navigateToDetailElectronicScreen()
            ServiceType.BOOK -> navigateToDetailBookScreen()
            ServiceType.SPORT -> navigateToDetailSportScreen()
        }
    }

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

    ModalBottomSheetLayout(
        sheetState = state,
        sheetShape = RoundedCornerShape(topStart = 12.dp, bottomEnd = 12.dp),
        sheetContent = {
            Spacer(modifier = Modifier.height(6.dp))
            FilterBottomSheetHeader(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                onClick = onResetFilterClick
            )
            Spacer(modifier = Modifier.height(6.dp))
            SingleChipFilter(
                onClick = onCategoryChanged,
                selectedOption = selectedCategoryFilter,
                options = categoryFilter,
                type = type
            )
            Spacer(modifier = Modifier.height(6.dp))
            MultipleChipFilter(
                onClick = onSubcategoryFilter,
                selectedOption = selectedSubCategoryFilter ,
                options = subCategoryFilter,
                type = type
            )
        },
        modifier = modifier.animateContentSize()
    ) {
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
                            .padding(top = 40.dp)
                    )
                    SearchBarWithFilter(
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp),
                        value = search,
                        texts = texts,
                        onValueChanged = onSearchAndFilterClick,
                        placeholder = "Search...",
                        onFilterClick = showFilterDialog
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
                            onClick = onItemClick
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

}

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
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