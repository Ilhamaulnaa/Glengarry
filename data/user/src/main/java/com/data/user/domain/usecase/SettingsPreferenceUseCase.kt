package com.data.user.domain.usecase

import kotlinx.coroutines.flow.Flow

interface SettingsPreferenceUseCase {

    val isLogin: Flow<Boolean>

    val isOnboarded: Flow<Boolean>

    suspend fun setLoginState(state: Boolean)

    suspend fun setIsOnboarded(state: Boolean)

}