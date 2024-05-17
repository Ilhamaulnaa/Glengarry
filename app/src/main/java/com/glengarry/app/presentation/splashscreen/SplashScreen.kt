package com.glengarry.app.presentation.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.R
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navigateToLoginScreen: () -> Unit = {}
) {

    LaunchedEffect(key1 = Unit){
        delay(3000L)
        navigateToLoginScreen()
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.glengarry_logo),
            contentDescription = "logo",
            modifier = Modifier
                .size(112.dp)
        )
        BaseText(
            text = "Glengarry",
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )
    }

}

@Preview
@Composable
fun SplashScreenPreview() {
    GlengarryTheme {
        Surface {
            SplashScreen()
        }
    }
}