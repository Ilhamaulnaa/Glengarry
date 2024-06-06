package com.glengarry.app.navigation

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
    override fun navigateToDetailFashionScreen() { navController.navigateToDetailFashionScreen()}
    override fun navigateToDetailElectronicScreen() { navController.navigateToDetailElectronicScreen() }
    override fun navigateToDetailBookScreen() { navController.navigateToDetailBookScreen() }
    override fun navigateToDetailSportScreen() { navController.navigateToDetailSportScreen() }
    override fun navigateToUnderConstructionScreen() { navController.navigateToUnderConstruction()}
    override fun navigateToPrivacyScreen() { navController.navigateToPrivacyScreen() }
    override fun navigateToPurchaseScreen() { navController.navigateToPurchaseScreen() }
    override fun navigateToHelpSupportScreen() { navController.navigateToHelpSupportScreen() }
    override fun navigateToInviteFriendScreen() { navController.navigateToInviteFriendScreen() }

}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToLoginScreen(
    clearBackStack:Boolean = true,
    from: Screen = Screen.Main
){
    navigate(Screen.Login.route){
        if (!clearBackStack) return@navigate
        popUpTo(from.route){
            inclusive = true
        }
    }
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
fun NavHostController.navigateToMainScreen(
    clearBackStack: Boolean = true,
    from: Screen = Screen.Login
) {
    navigate(Screen.Main.route) {
        if (!clearBackStack) return@navigate
        popUpTo(from.route) {
            inclusive = true
        }
    }
}
@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToUnderConstruction(showHomeButton: Boolean = true){
    navigate(Screen.UnderConstructionScreen.route)
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToDetailFashionScreen(){
    navigate(Screen.DetailFashion.route)
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToDetailElectronicScreen(){
    navigate(Screen.DetailElectronic.route)
}
@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToDetailBookScreen(){
    navigate(Screen.DetailBook.route)
}
@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToDetailSportScreen(){
    navigate(Screen.DetailSport.route)
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToPrivacyScreen(){
    navigate(Screen.Privacy.route)
}
@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToPurchaseScreen(){
    navigate(Screen.Purchase.route)
}
@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToHelpSupportScreen(){
    navigate(Screen.Help.route)
}
@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToInviteFriendScreen(){
    navigate(Screen.Invite.route)
}




