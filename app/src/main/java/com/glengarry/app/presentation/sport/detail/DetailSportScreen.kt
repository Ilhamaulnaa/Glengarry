package com.glengarry.app.presentation.sport.detail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.glengarry.app.presentation.sport.component.DetailSportHeader
import com.glengarry.app.presentation.sport.component.DetailSportInformationSection
import com.glengarry.app.presentation.sport.domain.SportDetail
import com.glengarry.app.ui.bottomnavigation.ButtonAttributes
import com.glengarry.app.ui.bottomnavigation.DetailBottomNavigation
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.topbar.DetailTopAppBar
import kotlinx.coroutines.launch

@ExperimentalLayoutApi
@ExperimentalMaterial3Api
@Composable
fun DetailSportScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit = {},
    sportId: String = ""
) {

    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }

    val onBuyClick: () -> Unit = {
        scope.launch {
            snackBarHostState.showSnackbar("Buy Fashion Not Implement Yet")
        }
    }

    val onCartClick: () -> Unit = {
        scope.launch {
            snackBarHostState.showSnackbar("Cart Fashion Not Implement Yet")
        }
    }

    val detail = SportDetail(
        id = "",
        img = "",
        label = listOf("Sport"),
        price = 760_000.0,
        name = "Raket Tenis Yonex Seri A Pro",
        rating = 4.5,
        detailProduct = "Etalase",
        description = "Harap pastikan pesanan sudah sesuai sebelum di checkout, produk dengan kualitas yg mampu bersaing dengan brand terkenal"
    )

    var primaryButtonTittle by remember {
        mutableStateOf("Buy Now")
    }
    var secondaryButtonTittle by remember {
        mutableStateOf("+ Cart")
    }

    val primaryButton by remember(key1 = primaryButtonTittle) {
        mutableStateOf(
            ButtonAttributes(
                title = primaryButtonTittle,
                onClick = onBuyClick,
            )
        )
    }
    val secondaryButton by remember(key1 = secondaryButtonTittle) {
        mutableStateOf(
            ButtonAttributes(
                title = secondaryButtonTittle,
                onClick = onCartClick,
            )
        )
    }

    Scaffold(
        topBar = {
            DetailTopAppBar(
                title = "",
                onNavigationClick = navigateUp
            )
        },
        bottomBar = {
            DetailBottomNavigation(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 16.dp),
                primaryButton = primaryButton,
                secondaryButton = secondaryButton,
            )
        },
        modifier = modifier
    ) { paddingValues ->

        AnimatedVisibility(
            visible = true,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .verticalScroll(scrollState)
            ) {
                DetailSportHeader(
                    details = detail,
                )
                Spacer(modifier = Modifier.height(12.dp))
                DetailSportInformationSection(
                    details = detail,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
        }

    }

}

@ExperimentalLayoutApi
@ExperimentalMaterial3Api
@Preview
@Composable
fun DetailSportScreenPreview() {
    GlengarryTheme {
        Surface {
            DetailSportScreen()
        }
    }
}