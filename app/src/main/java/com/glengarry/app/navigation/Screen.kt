package com.glengarry.app.navigation

sealed class Screen(val route: String){

    object Login: Screen(route = "login")

    object Register: Screen(route = "register")

}
