package com.glengarry.app.presentation.book.detail

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
import com.glengarry.app.presentation.book.component.DetailBookHeader
import com.glengarry.app.presentation.book.component.DetailBookInformationSection
import com.glengarry.app.presentation.book.domain.BookDetail
import com.glengarry.app.ui.bottomnavigation.ButtonAttributes
import com.glengarry.app.ui.bottomnavigation.DetailBottomNavigation
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.topbar.DetailTopAppBar
import kotlinx.coroutines.launch

@ExperimentalLayoutApi
@ExperimentalMaterial3Api
@Composable
fun DetailBookScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit = {},
    bookId: String = ""
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

    val detail = BookDetail(
        id = "",
        img = "",
        label = listOf("Book"),
        price = 75_000.0,
        name = "The Principle Of Power",
        rating = 4.9,
        detailProduct = "Etalase",
        description = "Harap pastikan pesanan sudah sesuai sebelum di checkout, produk dengan kualitas yg mampu bersaing dengan brand terkenal"
    )

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
                DetailBookHeader(
                    details = detail,
                )
                Spacer(modifier = Modifier.height(12.dp))
                DetailBookInformationSection(
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
fun DetailBookScreenPreview() {
    GlengarryTheme {
        Surface {
            DetailBookScreen()
        }
    }
}