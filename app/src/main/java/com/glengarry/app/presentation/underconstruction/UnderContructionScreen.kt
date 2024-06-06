@file:OptIn(ExperimentalMaterial3Api::class)

package com.glengarry.app.presentation.underconstruction

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.R
import com.glengarry.app.ui.button.PrimaryButton
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.topbar.DetailTopAppBar

@ExperimentalMaterial3Api
@Composable
fun UnderContructionScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit = {},
    navigateToMainScreen: () -> Unit = {},
    showHomeButton: Boolean = true
) {

    val onButtonClick: () -> Unit = {
        navigateToMainScreen()
    }

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
                .padding(horizontal = 40.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_under_construction),
                contentDescription = null,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(12.dp))
            BaseText(
                text = "Under Construction",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = Color(0xFF535353)
            )
            Spacer(modifier = Modifier.height(8.dp))
            BaseText(
                text = "Opss..The screen is under construction",
                fontSize = 14.sp,
                color = Color(0xFF535353)
            )
            if (showHomeButton){
                Spacer(modifier = Modifier.height(16.dp))
                PrimaryButton(
                    text = "Home",
                    onClick = onButtonClick,
                    enabled = showHomeButton,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }

    }

}

@ExperimentalMaterial3Api
@Preview
@Composable
fun UnderContructionScreenPreview() {
    GlengarryTheme {
        Surface {
            UnderContructionScreen()
        }
    }
}