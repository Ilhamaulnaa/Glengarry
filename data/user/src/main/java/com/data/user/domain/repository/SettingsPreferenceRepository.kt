package com.data.user.domain.repository

import kotlinx.coroutines.flow.Flow

interface SettingsPreferenceRepository {

    val isLogin: Flow<Boolean>

    val isOnboarded: Flow<Boolean>

    suspend fun setLoginState(state: Boolean)

    suspend fun setIsOnboarded(state: Boolean)

}