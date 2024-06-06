package com.glengarry.app.presentation.profile.listmenu.helpsupport

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.topbar.DetailTopAppBar

@ExperimentalMaterial3Api
@Composable
fun HelpSupportScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit = {}
) {

    Scaffold(
        topBar = {
            DetailTopAppBar(
                title = "",
                onNavigationClick = navigateUp
            )
        },
        modifier = modifier
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BaseText(
                text = "This Screen \nComingSoon",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }

}

@ExperimentalMaterial3Api
@Preview
@Composable
fun HelpSupportScreenPreview() {
    GlengarryTheme {
        Surface {
            HelpSupportScreen()
        }
    }
}