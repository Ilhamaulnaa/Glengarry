package com.data.user.di

import com.data.user.domain.interactor.UserInteractor
import com.data.user.domain.interactor.UserPreferencesInteractor
import com.data.user.domain.usecase.UserPreferencesUseCase
import com.data.user.domain.usecase.UserUseCase
import org.koin.dsl.module

val dataUserModule = module {
    // Domain
//    single<SettingsPreferenceUseCase> { SettingsPreferenceInteractor(get()) }
    single<UserPreferencesUseCase> { UserPreferencesInteractor(get()) }
    single<UserUseCase> { UserInteractor(get()) }

    // Data
//    single<UserService> {
//        get<Retrofit>().create(UserService::class.java)
//    }
//    single<DataStore<UserPreferencesDataStore>> {
//        get<Context>().userPreferenceDataStoreModule
//    }
//    single { SettingsPreferenceDataStore(get()) }
//    single<SettingsPreferenceRepository> { SettingsPreferenceRepositoryImpl(get()) }
//    single<UserPreferencesRepository> { UserPreferencesRepositoryImpl(get()) }
//    single<UserRepository> { UserRepositoryImpl(get()) }
}