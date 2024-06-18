package com.data.user.data

import androidx.datastore.core.DataStore
import com.data.user.data.datastore.UserPreferencesDataStore
import com.data.user.data.mapper.toDomain
import com.data.user.domain.model.UserPreferences
import com.data.user.domain.repository.UserPreferencesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferencesRepositoryImpl(
    private val dataStore: DataStore<UserPreferencesDataStore>
) : UserPreferencesRepository {

    override val userPreference: Flow<UserPreferences>
        get() = dataStore.data.map { preferences ->
            preferences.toDomain()
        }

    override suspend fun updateUserPreferences(userPreference: UserPreferences) {
        dataStore.updateData { preference ->
            preference.toBuilder()
                .setName(userPreference.name)
                .setEmail(userPreference.email)
                .setAccessToken(userPreference.accessToken)
                .setRefreshToken(userPreference.refreshToken)
                .build()
        }
    }

    override suspend fun updateUserNamePreferences(name: String) {
        dataStore.updateData { preference ->
            preference.toBuilder()
                .setName(name)
                .build()
        }
    }

    override suspend fun updateAccessToken(accessToken: String) {
        dataStore.updateData { preference ->
            preference.toBuilder()
                .setAccessToken(accessToken)
                .build()
        }
    }
}