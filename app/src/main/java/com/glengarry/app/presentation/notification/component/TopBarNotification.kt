package com.glengarry.app.presentation.notification.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.R
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme

@ExperimentalMaterial3Api
@Composable
fun TopBarNotification(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit = {}
) {

    TopAppBar(
        title = {
            Row (
                modifier = modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                BaseText(
                    text = title,
                    fontSize = 18.sp,
                    lineHeight = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF2D2D2D),
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_notification) ,
                    contentDescription = "notification",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { onClick }
                )
            }
        },
        modifier
    )
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun TopBarNotificationPreview() {
    GlengarryTheme {
        Surface {
            TopBarNotification(
                modifier = Modifier.padding(20.dp),
                title = "Notification"
            )
        }
    }
}