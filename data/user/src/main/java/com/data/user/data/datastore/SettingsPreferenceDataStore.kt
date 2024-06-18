package com.data.user.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
class SettingsPreferenceDataStore(
    private val context: Context
) {

    private val dataStore get() = context.dataStore

    companion object {
        val isLoginKey = booleanPreferencesKey("is_login")
        val isFirstOpenKey = booleanPreferencesKey("is_first_open")
    }

    val isLogin: Flow<Boolean>
        get() = dataStore.data.map { preferences ->
        preferences[isLoginKey] ?: false
    }

    val isOnboarded: Flow<Boolean> get() = dataStore.data.map { preferences ->
        preferences[isFirstOpenKey] ?: false
    }

    suspend fun setLoginState(state: Boolean) {
        dataStore.edit { preferences ->
            preferences[isLoginKey] = state
        }
    }

    suspend fun setIsOnboarded(state: Boolean) {
        dataStore.edit { preferences ->
            preferences[isFirstOpenKey] = state
        }
    }

}