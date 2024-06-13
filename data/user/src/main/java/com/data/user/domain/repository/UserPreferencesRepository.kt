package com.data.user.domain.repository

import com.data.user.domain.model.UserPreferences
import kotlinx.coroutines.flow.Flow

interface UserPreferencesRepository {

    val userPreference: Flow<UserPreferences>

    suspend fun updateUserPreferences(userPreference: UserPreferences)

    suspend fun updateUserNamePreferences(name: String)

    suspend fun updateAccessToken(accessToken: String)

}