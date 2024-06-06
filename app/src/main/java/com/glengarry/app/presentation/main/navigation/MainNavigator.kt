package com.glengarry.app.presentation.main.navigation


interface MainNavigator {
    fun navigateToLoginScreen()
    fun navigateToRegisterScreen()
    fun navigateToForgotPassordScreen()
    fun navigateToMainScreen()
    fun navigateToDetailFashionScreen()
    fun navigateToDetailElectronicScreen()
    fun navigateToDetailBookScreen()
    fun navigateToDetailSportScreen()
    fun navigateToUnderConstructionScreen()
    fun navigateToPrivacyScreen()
    fun navigateToPurchaseScreen()
    fun navigateToHelpSupportScreen()
    fun navigateToInviteFriendScreen()

}

object EmptyMainNavigator: MainNavigator{
    override fun navigateToLoginScreen() {}
    override fun navigateToRegisterScreen() {}
    override fun navigateToForgotPassordScreen() {}
    override fun navigateToMainScreen() {}
    override fun navigateToDetailFashionScreen() {}
    override fun navigateToDetailElectronicScreen() {}
    override fun navigateToDetailBookScreen() {}
    override fun navigateToDetailSportScreen() {}
    override fun navigateToUnderConstructionScreen() {}
    override fun navigateToPrivacyScreen() {}
    override fun navigateToPurchaseScreen() {}
    override fun navigateToHelpSupportScreen() {}
    override fun navigateToInviteFriendScreen() {}
}