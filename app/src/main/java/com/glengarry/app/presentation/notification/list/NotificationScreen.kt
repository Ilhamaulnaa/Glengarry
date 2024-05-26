package com.glengarry.app.presentation.notification.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.core.domain.model.ServiceItem
import com.glengarry.app.R
import com.glengarry.app.presentation.notification.component.EmptyContentNotification
import com.glengarry.app.presentation.notification.component.NotificationItem
import com.glengarry.app.presentation.notification.component.TopBarNotification
import com.glengarry.app.presentation.notification.domain.ListItem
import com.glengarry.app.ui.theme.GlengarryTheme

@ExperimentalMaterial3Api
@Composable
fun NotificationScreen(
    modifier: Modifier = Modifier,
) {

    val listItem = remember {
        listOf(
            ListItem(
                label = "Today",
                icon = R.drawable.ic_discount,
                title = "30% Special Discount!",
                description = "Special promotion only valid today.",
            ),
            ListItem(
                label = "Yesterday",
                icon = R.drawable.ic_wallet,
                title = "Top Up E-wallet Successfully!",
                description = "You have top up your e-wallet.",
            ),
            ListItem(
                icon = R.drawable.ic_location,
                title = "New Service Available!",
                description = "Now you can track order in real-time.",
            ),
            ListItem(
                label = "June 7, 2023",
                icon = R.drawable.ic_card,
                title = "Credit Card Connected!",
                description = "Credit card has been linked.",
            ),
            ListItem(
                icon = R.drawable.ic_user,
                title = "Account Setup Successfully!",
                description = "Your account has been created.",
            ),

        )
    }

    Scaffold(
        topBar = {
            TopBarNotification(
                title = "notification"
            )
        },
        modifier = modifier
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues),
        ){
            items(items = listItem){ notificationList ->
                if (listItem.isNotEmpty()){
                    NotificationItem(
                        listItem = notificationList,
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                    )
                }else{
                    EmptyContentNotification()
                }
            }
        }

    }

}

@ExperimentalMaterial3Api
@Preview
@Composable
fun NotificationScreenPreview() {
    GlengarryTheme {
        Surface {
            NotificationScreen()
        }
    }
}