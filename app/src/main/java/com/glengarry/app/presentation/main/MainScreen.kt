package com.glengarry.app.presentation.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBusiness
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.glengarry.app.presentation.home.HomeScreen
import com.glengarry.app.presentation.main.component.BottomBar
import com.glengarry.app.presentation.main.navigation.EmptyMainNavigator
import com.glengarry.app.presentation.main.navigation.MainNavigator
import com.glengarry.app.presentation.main.navigation.Screen
import com.glengarry.app.presentation.notification.list.NotificationScreen
import com.glengarry.app.presentation.profile.ProfileScreen
import com.glengarry.app.presentation.shop.ShopScreen
import com.glengarry.app.ui.theme.GlengarryTheme

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@ExperimentalLayoutApi
@ExperimentalFoundationApi
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    mainNavigator: MainNavigator
) {

    Scaffold(
        bottomBar = {
            BottomBar(
                navController = navController,
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
            )
        },
        floatingActionButton = {
            Box(
                modifier = Modifier
                    .offset(y = 40.dp)
                    .clip(CircleShape)
                    .clickable { mainNavigator.navigateToAddBusinessScreen() }
                    .size(40.dp)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ){
                androidx.compose.material3.Icon(
                    imageVector = Icons.Filled.AddBusiness,
                    contentDescription = "add",
                    tint = Color.Black,
                    modifier = Modifier.size(30.dp)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        modifier = modifier
    ) { paddingValues ->

       NavHost(
           navController = navController,
           startDestination = Screen.Home.route,
           modifier = Modifier
               .padding(bottom = paddingValues.calculateBottomPadding() - 48.dp )
       ){
           composable(Screen.Home.route){
               HomeScreen(
                   navigateToDetailFashionScreen = mainNavigator::navigateToDetailFashionScreen,
                   navigateToDetailElectronicScreen = mainNavigator::navigateToDetailElectronicScreen,
                   navigateToDetailBookScreen = mainNavigator::navigateToDetailBookScreen,
                   navigateToDetailSportScreen = mainNavigator::navigateToDetailSportScreen,
                   navigateToFashionMenuScreen = mainNavigator::navigateToFashionMenuScreen,
                   navigateToElectronicMenuScreen = mainNavigator::navigateToElectronicMenuScreen,
                   navigateToBookMenuScreen = mainNavigator::navigateToBookMenuScreen,
                   navigateToSportMenuScreen = mainNavigator::navigateToSportMenuScreen,

               )
           }
           composable(Screen.Notification.route){
               NotificationScreen()
           }
           composable(Screen.Shop.route){
               ShopScreen()
           }
           composable(Screen.Profile.route){
               ProfileScreen(
                   navigateToLoginScreen = mainNavigator::navigateToLoginScreen,
                   navigateToPrivacyScreen = mainNavigator::navigateToPrivacyScreen,
                   navigateToPurchaseScreen = mainNavigator::navigateToPurchaseScreen,
                   navigateToHelpScreen = mainNavigator::navigateToHelpSupportScreen,
                   navigateToInviteScreen = mainNavigator::navigateToInviteFriendScreen
               )
           }
       }
    }
    
}

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@ExperimentalLayoutApi
@ExperimentalFoundationApi
@Preview
@Composable
fun MainScreenPreview() {
    GlengarryTheme {
        Surface {
            MainScreen(mainNavigator = EmptyMainNavigator)
        }
    }
}