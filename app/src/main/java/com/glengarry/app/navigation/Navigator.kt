package com.glengarry.app.navigation

import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.glengarry.app.presentation.main.navigation.MainNavigator
import kotlin.jvm.Throws

class NavMainNavigator(
    private val navController: NavHostController
): MainNavigator {
    override fun navigateToLoginScreen() { navController.navigateToLoginScreen() }

    override fun navigateToRegisterScreen() { navController.navigateToRegisterScreen() }
    override fun navigateToForgotPassordScreen() { navController.navigateToForgotPasswordScreen() }

    override fun navigateToMainScreen() { navController.navigateToMainScreen() }
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToLoginScreen(){
    navigate(Screen.Login.route)
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToRegisterScreen(){
    navigate(Screen.Register.route)
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToForgotPasswordScreen(){
    navigate(Screen.ForgotPassword.route)
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToMainScreen(){
    navigate(Screen.Main.route)
}

