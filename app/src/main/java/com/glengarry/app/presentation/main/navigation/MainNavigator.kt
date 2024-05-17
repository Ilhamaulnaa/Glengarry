package com.glengarry.app.presentation.main.navigation

import androidx.compose.runtime.Composable

interface MainNavigator {
    fun navigateToLoginScreen()
    fun navigateToRegisterScreen()
    fun navigateToForgotPassordScreen()
    fun navigateToMainScreen()
}

object EmptyMainNavigator: MainNavigator{
    override fun navigateToLoginScreen() {}
    override fun navigateToRegisterScreen() {}
    override fun navigateToForgotPassordScreen() {}
    override fun navigateToMainScreen() {}
}