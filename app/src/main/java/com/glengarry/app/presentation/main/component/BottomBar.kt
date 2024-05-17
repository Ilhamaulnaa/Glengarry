package com.glengarry.app.presentation.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.glengarry.app.R
import com.glengarry.app.presentation.main.navigation.NavigationItem
import com.glengarry.app.presentation.main.navigation.Screen

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val home = NavigationItem(
        title = "home",
        screen = Screen.Home,
        icon = R.drawable.ic_home,
        iconActive = R.drawable.ic_home_active
    )
    val notification = NavigationItem(
        title = "notification",
        screen = Screen.Notification,
        icon = R.drawable.ic_notification,
        iconActive = R.drawable.ic_notification_active
    )
    val shop = NavigationItem(
        title = "shop",
        screen = Screen.Shop,
        icon = R.drawable.ic_shop,
        iconActive = R.drawable.ic_shop_active
    )
    val profile = NavigationItem(
        title = "profile",
        screen = Screen.Profile,
        icon = R.drawable.ic_profile,
        iconActive = R.drawable.ic_profile_active
    )
    Row (
        modifier = modifier
            .height(70.dp)
            .padding(horizontal = 28.dp, vertical = 24.dp)
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){

        IconButton(
            onClick = {
                navController.navigate(home.screen.route){
                    popUpTo(navController.graph.findStartDestination().id){
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        ) {
            val selected = currentDestination?.hierarchy?.any{ it.route == home.screen.route } == true
            val icon = if (selected){
                home.iconActive
            }else{
                home.icon
            }
            Image(
                painter = painterResource(id = icon),
                contentDescription = home.title,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(24.dp)
                    .size(24.dp)
            )
        }
        IconButton(
            onClick = {
                navController.navigate(notification.screen.route) {
                    popUpTo(navController.graph.findStartDestination().id){
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        ) {
            val selected = currentDestination?.hierarchy?.any { it.route == notification.screen.route } == true
            val icon = if (selected){
                notification.iconActive
            }else{
                notification.icon
            }
            Image(
                painter = painterResource(id = icon),
                contentDescription = notification.title,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(32.dp)
                    .size(24.dp)
            )
        }
        Spacer(modifier = Modifier.padding(horizontal = 12.dp))
        IconButton(
            onClick = {
                navController.navigate(shop.screen.route){
                    popUpTo(navController.graph.findStartDestination().id){
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        ) {
            val selected = currentDestination?.hierarchy?.any { it.route == shop.screen.route } == true
            val icon = if (selected){
                shop.iconActive
            }else{
                shop.icon
            }
            Image(
                painter = painterResource(id = icon),
                contentDescription = shop.title,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(24.dp)
                    .size(24.dp)
            )
        }
        IconButton(
            onClick = {
                navController.navigate(profile.screen.route){
                    popUpTo(navController.graph.findStartDestination().id){
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        ) {
            val selected = currentDestination?.hierarchy?.any { it.route == profile.screen.route } == true
            val icon = if (selected){
                profile.iconActive
            }else{
                profile.icon
            }
            Image(
                painter = painterResource(id = icon),
                contentDescription = profile.title,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(24.dp)
                    .size(24.dp)
            )
        }
    }

}