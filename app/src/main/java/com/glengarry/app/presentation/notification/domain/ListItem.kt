package com.glengarry.app.presentation.notification.domain

import androidx.annotation.DrawableRes

data class ListItem(
    val id: String = "",
    val label: String = "",
    @DrawableRes
    val icon: Int,
    val title: String,
    val description: String
)