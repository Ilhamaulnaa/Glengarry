package com.glengarry.app.ui.topbar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.theme.poppinsFontFamily

@ExperimentalMaterial3Api
@Composable
fun DetailTopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    onNavigationClick: () -> Unit = {}
) {

    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){

        IconButton(
            onClick = { onNavigationClick() }
        ) {

            Icon(
                imageVector = Icons.Filled.ArrowBackIos,
                contentDescription = "back"
            )

        }
        Spacer(modifier = Modifier.width(16.dp))
        BaseText(
            text = title,
            fontSize = 18.sp,
            lineHeight = 30.sp,
            color = Color(0xFF000000)
        )
    }

//    TopAppBar(
//        title = {
//            Text(
//                text = title,
//                fontSize = 18.sp,
//                lineHeight = 30.sp,
//                fontFamily = poppinsFontFamily,
//                fontWeight = FontWeight.SemiBold,
//                color = Color(0xFF2D2D2D)
//            )
//        },
//        navigationIcon = {
//            androidx.compose.material3.IconButton(onClick = onNavigationClick) {
//                androidx.compose.material3.Icon(
//                    imageVector = Icons.Filled.ArrowBackIosNew,
//                    contentDescription = "Back"
//                )
//            }
//        },
//        modifier = modifier
//    )

}

@ExperimentalMaterial3Api
@Preview
@Composable
fun DetailTopAppBarPreview() {
    GlengarryTheme {
        DetailTopAppBar(
            title = "Notification",
            onNavigationClick = {}
        )
    }
}