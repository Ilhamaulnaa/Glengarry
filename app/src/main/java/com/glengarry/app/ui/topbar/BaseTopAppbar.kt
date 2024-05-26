package com.glengarry.app.ui.topbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.theme.poppinsFontFamily

@ExperimentalMaterial3Api
@Composable
fun BaseTopAppBar(
    modifier: Modifier = Modifier,
    title: String
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 18.sp,
                lineHeight = 30.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF2D2D2D),
            )
        },
        modifier
    )
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewBaseTopAppBar() {
    GlengarryTheme {
        Surface {
            BaseTopAppBar(
                title = "Notifications"
            )
        }
    }
}