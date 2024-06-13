package com.data.user.domain.interactor

import com.data.user.domain.repository.SettingsPreferenceRepository
import com.data.user.domain.usecase.SettingsPreferenceUseCase
import kotlinx.coroutines.flow.Flow

class SettingsPreferenceInteractor(
    private val repository: SettingsPreferenceRepository
) : SettingsPreferenceUseCase {

    override val isLogin: Flow<Boolean>
        get() = repository.isLogin

    override val isOnboarded: Flow<Boolean>
        get() = repository.isOnboarded

    override suspend fun setLoginState(state: Boolean) {
        repository.setLoginState(state)
    }

    override suspend fun setIsOnboarded(state: Boolean) {
        repository.setIsOnboarded(state)
    }
}