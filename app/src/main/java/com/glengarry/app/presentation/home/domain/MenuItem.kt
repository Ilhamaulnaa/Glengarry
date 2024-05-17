package com.glengarry.app.presentation.home.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MenuItem(
    @DrawableRes
    val icon: Int,
    @StringRes
    val label: Int
)
