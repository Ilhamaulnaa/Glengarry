package com.glengarry.app.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.glengarry.app.presentation.addbusiness.AddBusinessScreen
import com.glengarry.app.presentation.auth.login.LoginScreen
import com.glengarry.app.presentation.auth.register.RegisterScreen
import com.glengarry.app.presentation.book.detail.DetailBookScreen
import com.glengarry.app.presentation.book.list.BookMenuScreen
import com.glengarry.app.presentation.electronic.detail.DetailElectronicScreen
import com.glengarry.app.presentation.electronic.list.ElectronicMenuScreen
import com.glengarry.app.presentation.fashion.detail.DetailFashionScreen
import com.glengarry.app.presentation.fashion.list.FashionMenuScreen
import com.glengarry.app.presentation.main.MainScreen
import com.glengarry.app.presentation.profile.listmenu.helpsupport.HelpSupportScreen
import com.glengarry.app.presentation.profile.listmenu.invitefriend.InviteFriendScreen
import com.glengarry.app.presentation.profile.listmenu.privacy.PrivacyScreen
import com.glengarry.app.presentation.profile.listmenu.purchase.PurchaseScreen
import com.glengarry.app.presentation.splashscreen.SplashScreen
import com.glengarry.app.presentation.sport.detail.DetailSportScreen
import com.glengarry.app.presentation.sport.list.SportMenuScreen
import com.glengarry.app.presentation.underconstruction.UnderContructionScreen

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@ExperimentalLayoutApi
@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@Composable
fun GlengarryNavHost(
    startDestination: Screen = Screen.Splashscreen,
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
                navigateToMainScreen = navController::navigateToMainScreen,

            )
        }
        composableWithSlideHorizontalAnimation(Screen.Register.route){
            RegisterScreen()
        }
        composableWithSlideHorizontalAnimation(Screen.Main.route){
            val mainNavigator = NavMainNavigator(navController)
            MainScreen(mainNavigator = mainNavigator)
        }
        composableWithSlideHorizontalAnimation(
            route = Screen.DetailFashion.route,
            arguments = listOf(
                navArgument(Screen.FASHION_ID) {
                    type = NavType.StringType
                }
            )
        ){
            val fashionId = it.arguments?.getString(Screen.FASHION_ID) ?: ""
            DetailFashionScreen(
                navigateUp = navController::navigateUp,
                fashionId = fashionId
            )
        }
        composableWithSlideHorizontalAnimation(Screen.DetailElectronic.route){
            DetailElectronicScreen(
                navigateUp = navController::navigateUp
            )
        }
//        composableWithSlideHorizontalAnimation(
//            route = Screen.DetailElectronic.route,
//            arguments = listOf(
//                navArgument(Screen.ELECTRONIC_ID) {
//                    type = NavType.StringType
//                }
//            )
//        ){
//            val electronicId = it.arguments?.getString(Screen.ELECTRONIC_ID) ?: ""
//            DetailElectronicScreen(
//                navigateUp = navController::navigateUp,
//                electronicId = electronicId
//            )
//        }
        composableWithSlideHorizontalAnimation(
            route = Screen.DetailBook.route,
            arguments = listOf(
                navArgument(Screen.BOOK_ID) {
                    type = NavType.StringType
                }
            )
        ){
            val bookId = it.arguments?.getString(Screen.BOOK_ID) ?: ""
            DetailBookScreen(
                navigateUp = navController::navigateUp,
                bookId = bookId
            )
        }
        composableWithSlideHorizontalAnimation(
            route = Screen.DetailSport.route,
            arguments = listOf(
                navArgument(Screen.SPORT_ID) {
                    type = NavType.StringType
                }
            )
        ){
            val sportId = it.arguments?.getString(Screen.SPORT_ID) ?: ""
            DetailSportScreen(
                navigateUp = navController::navigateUp,
                sportId = sportId
            )
        }
        composableWithSlideHorizontalAnimation(
            route = Screen.UnderConstructionScreen.route,
            arguments = listOf(
                navArgument(Screen.SHOW_HOME_BUTTON) {
                    type = NavType.BoolType
                }
            )
        ){
            val showHomeButton = it.arguments?.getBoolean(Screen.SHOW_HOME_BUTTON) ?: true
            UnderContructionScreen(
                navigateUp = navController::navigateUp,
                navigateToMainScreen = { navController.navigateToMainScreen(from = Screen.UnderConstructionScreen) },
                showHomeButton = showHomeButton
            )
        }
        composableWithSlideHorizontalAnimation(Screen.Privacy.route){
            PrivacyScreen(
                navigateUp = navController::navigateUp
            )
        }
        composableWithSlideHorizontalAnimation(Screen.Purchase.route){
            PurchaseScreen(
                navigateUp = navController::navigateUp
            )
        }
        composableWithSlideHorizontalAnimation(Screen.Help.route){
            HelpSupportScreen(
                navigateUp = navController::navigateUp
            )
        }
        composableWithSlideHorizontalAnimation(Screen.Invite.route){
            InviteFriendScreen(
                navigateUp = navController::navigateUp
            )
        }
        composableWithSlideHorizontalAnimation(Screen.FashionMenu.route){
            FashionMenuScreen(
                navigateUp = navController::navigateUp
            )
        }
        composableWithSlideHorizontalAnimation(Screen.ElectronicMenu.route){
            ElectronicMenuScreen(
                navigateUp = navController::navigateUp
            )
        }
        composableWithSlideHorizontalAnimation(Screen.BookMenu.route){
            BookMenuScreen(
                navigateUp = navController::navigateUp
            )
        }
        composableWithSlideHorizontalAnimation(Screen.SportMenu.route){
            SportMenuScreen(
                navigateUp = navController::navigateUp
            )
        }
        composableWithSlideHorizontalAnimation(Screen.AddBusiness.route){
            AddBusinessScreen()
        }
    }

}