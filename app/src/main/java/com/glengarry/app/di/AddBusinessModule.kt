package com.glengarry.app.di

import com.glengarry.app.presentation.addbusiness.AddBusinessViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val addBusinessModule = module {
    viewModel { AddBusinessViewModel(get(), get(), get(), get(), get(), get() ) }
}