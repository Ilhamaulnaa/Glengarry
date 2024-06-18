package com.data.user.data

import com.data.user.data.datastore.SettingsPreferenceDataStore
import com.data.user.domain.repository.SettingsPreferenceRepository
import kotlinx.coroutines.flow.Flow

class SettingsPreferenceRepositoryImpl(
    private val dataStore: SettingsPreferenceDataStore
) : SettingsPreferenceRepository {

    override val isLogin: Flow<Boolean>
        get() = dataStore.isLogin

    override val isOnboarded: Flow<Boolean>
        get() = dataStore.isOnboarded

    override suspend fun setLoginState(state: Boolean) {
        dataStore.setLoginState(state)
    }

    override suspend fun setIsOnboarded(state: Boolean) {
        dataStore.setIsOnboarded(state)
    }
}