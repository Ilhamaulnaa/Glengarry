package com.data.user.di

import android.content.Context
import androidx.datastore.core.DataStore
import com.data.user.data.SettingsPreferenceRepositoryImpl
import com.data.user.data.UserPreferencesRepositoryImpl
import com.data.user.data.UserRepositoryImpl
import com.data.user.data.datastore.SettingsPreferenceDataStore
import com.data.user.data.datastore.UserPreferencesDataStore
import com.data.user.data.datastore.userPreferenceDataStoreModule
import com.data.user.data.remote.service.UserService
import com.data.user.domain.interactor.SettingsPreferenceInteractor
import com.data.user.domain.interactor.UserInteractor
import com.data.user.domain.interactor.UserPreferencesInteractor
import com.data.user.domain.repository.SettingsPreferenceRepository
import com.data.user.domain.repository.UserPreferencesRepository
import com.data.user.domain.repository.UserRepository
import com.data.user.domain.usecase.SettingsPreferenceUseCase
import com.data.user.domain.usecase.UserPreferencesUseCase
import com.data.user.domain.usecase.UserUseCase
import org.koin.dsl.module
import retrofit2.Retrofit

val dataUserModule = module {
    // Domain
    single<SettingsPreferenceUseCase> { SettingsPreferenceInteractor(get()) }
    single<UserPreferencesUseCase> { UserPreferencesInteractor(get()) }
    single<UserUseCase> { UserInteractor(get()) }

    // Data
    single<UserService> {
        get<Retrofit>().create(UserService::class.java)
    }
    single<DataStore<UserPreferencesDataStore>> {
        get<Context>().userPreferenceDataStoreModule
    }
    single { SettingsPreferenceDataStore(get()) }
    single<SettingsPreferenceRepository> { SettingsPreferenceRepositoryImpl(get()) }
    single<UserPreferencesRepository> { UserPreferencesRepositoryImpl(get()) }
    single<UserRepository> { UserRepositoryImpl(get()) }
}