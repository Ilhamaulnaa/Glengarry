package com.data.user.domain.model

data class UserPreferences(
    val name: String = "",
    val email: String = "",
    val accessToken: String = "",
    val refreshToken: String = "",
)
