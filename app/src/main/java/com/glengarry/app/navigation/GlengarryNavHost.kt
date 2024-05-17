package com.glengarry.app.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.glengarry.app.presentation.auth.login.LoginScreen
import com.glengarry.app.presentation.auth.register.RegisterScreen
import com.glengarry.app.presentation.main.MainScreen
import com.glengarry.app.presentation.main.navigation.EmptyMainNavigator
import com.glengarry.app.presentation.splashscreen.SplashScreen

@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@Composable
fun GlengarryNavHost(
    startDestination: Screen = Screen.Main,
    navController: NavHostController = rememberNavController()
) {

    val startDestinationRoute = startDestination.route

    NavHost(navController = navController, startDestination = startDestinationRoute){
        composableWithSlideHorizontalAnimation(Screen.Splashscreen.route){
            SplashScreen(
                navigateToLoginScreen = navController::navigateToLoginScreen
            )
        }
        composableWithSlideHorizontalAnimation(Screen.Login.route){
            LoginScreen(
                navigateToRegisterScreen = navController::navigateToRegisterScreen,
                navigateToMainScreen = navController::navigateToMainScreen
            )
        }
        composableWithSlideHorizontalAnimation(Screen.Register.route){
            RegisterScreen()
        }
        composableWithSlideHorizontalAnimation(Screen.Main.route){
            val mainNavigator = NavMainNavigator(navController)
            MainScreen(mainNavigator = mainNavigator)
        }
    }

}