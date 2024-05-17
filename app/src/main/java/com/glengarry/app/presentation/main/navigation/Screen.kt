package com.glengarry.app.presentation.main.navigation

sealed class Screen (val route: String){
    object Home: Screen("home")
    object Notification: Screen("notification")
    object Shop: Screen("shop")
    object Profile: Screen("profile")
}