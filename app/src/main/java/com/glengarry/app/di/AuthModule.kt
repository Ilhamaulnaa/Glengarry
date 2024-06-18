package com.glengarry.app.di

import com.data.user.domain.interactor.SettingsPreferenceInteractor
import com.data.user.domain.usecase.SettingsPreferenceUseCase
import com.data.user.domain.usecase.UserPreferencesUseCase
import com.data.user.domain.usecase.UserUseCase
import com.glengarry.app.presentation.auth.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authModule = module {
    viewModel { LoginViewModel(get(), get(), get()) }
}