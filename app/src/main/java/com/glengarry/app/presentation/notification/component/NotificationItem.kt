package com.glengarry.app.presentation.notification.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.glengarry.app.R
import com.glengarry.app.presentation.notification.domain.ListItem
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.theme.grey

@Composable
fun NotificationItem(
    modifier: Modifier = Modifier,
    listItem: ListItem,
    onClick: (ListItem) -> Unit = {},
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        BaseText(
            text = listItem.label,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
        Row(
            modifier = Modifier
                .clickable { onClick(listItem) },
        ) {
            Image(
                modifier = Modifier
                    .size(39.dp),
                painter = painterResource(id = listItem.icon),
                contentDescription = "icon"
            )
            Spacer(modifier = Modifier.width(6.dp))
            Column (horizontalAlignment = Alignment.Start){
                BaseText(
                    text = listItem.title,
                    fontSize = 14.sp
                )
                BaseText(
                    text = listItem.description,
                    fontSize = 12.sp,
                    color = Color(0xFF808080)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color(0xFFE6E6E6)
        )
        Spacer(modifier = Modifier.height(20.dp))
    }

}

@Preview
@Composable
fun NotificationItemPreview() {
    GlengarryTheme {
        Surface {
            val listItem = ListItem(
                label = "Today",
                icon = R.drawable.ic_discount,
                title = "30% Special Discount!",
                description = "Special promotion only valid today.",
            )
            NotificationItem(
                listItem = listItem,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}