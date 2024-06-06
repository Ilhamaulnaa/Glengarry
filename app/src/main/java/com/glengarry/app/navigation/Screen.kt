package com.glengarry.app.navigation

import com.glengarry.app.ui.buttomsheet.sportChipBorder

sealed class Screen(val route: String){

    companion object {
        const val FASHION_ID = "fashion_id"
        const val ELECTRONIC_ID = "electronic_id"
        const val BOOK_ID = "book_id"
        const val SPORT_ID = "sport_id"
        const val TOKEN = "token"
        const val SHOW_HOME_BUTTON = "home_button"
    }

    object Splashscreen: Screen(route = "splash-screen")
    object Login: Screen(route = "login")
    object Register: Screen(route = "register")
    object ForgotPassword: Screen(route = "forgot-password")
    object Main: Screen(route = "main")
    object UnderConstructionScreen: Screen(route = "under_construction")
    object Privacy: Screen(route = "privacy")
    object Purchase: Screen(route = "purchase")
    object Help: Screen(route = "help")
    object Invite: Screen(route = "invite")

    object DetailFashion: Screen(route = "detail_fashion/{$FASHION_ID}"){
        fun generateRoute(fashionId: String): String{
            return "detail_fashion/$fashionId"
        }
    }
    object DetailElectronic: Screen(route = "detail_electronic/{$ELECTRONIC_ID"){
        fun generateRoute(electronicId: String): String{
            return "detail_electronic/$electronicId"
        }
    }
    object DetailBook: Screen(route = "detail_book/{$BOOK_ID}"){
        fun generateRoute(bookId: String): String {
            return "detail_book/$bookId"
        }
    }
    object DetailSport: Screen(route = "detail_sport/{$SPORT_ID}"){
        fun generateRoute(sportId: String): String {
            return "detail_sport/$sportId"
        }
    }
}
