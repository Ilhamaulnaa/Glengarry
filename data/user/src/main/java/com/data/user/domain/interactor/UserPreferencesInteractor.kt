package com.data.user.domain.interactor

import com.data.user.domain.model.UserPreferences
import com.data.user.domain.repository.UserPreferencesRepository
import com.data.user.domain.usecase.UserPreferencesUseCase
import kotlinx.coroutines.flow.Flow

class UserPreferencesInteractor(
    private val repository: UserPreferencesRepository
) : UserPreferencesUseCase {

    override val userPreference: Flow<UserPreferences>
        get() = repository.userPreference

    override suspend fun updateUserPreferences(userPreference: UserPreferences) {
        repository.updateUserPreferences(userPreference)
    }

    override suspend fun updateUserNamePreferences(name: String) {
        repository.updateUserNamePreferences(name)
    }

    override suspend fun updateAccessToken(accessToken: String) {
        repository.updateAccessToken(accessToken)
    }
}