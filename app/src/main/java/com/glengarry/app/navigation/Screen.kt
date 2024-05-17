package com.glengarry.app.navigation

sealed class Screen(val route: String){

    object Splashscreen: Screen(route = "splash-screen")
    object Login: Screen(route = "login")
    object Register: Screen(route = "register")
    object ForgotPassword: Screen(route = "forgot-password")
    object Main: Screen(route = "main")

}
