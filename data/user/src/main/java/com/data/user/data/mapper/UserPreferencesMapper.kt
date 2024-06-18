package com.data.user.data.mapper

import com.data.user.data.datastore.UserPreferencesDataStore
import com.data.user.domain.model.UserPreferences

fun UserPreferencesDataStore.toDomain(): UserPreferences {
    return UserPreferences(
        name = name,
        email = email,
        accessToken = accessToken,
        refreshToken = refreshToken
    )
}