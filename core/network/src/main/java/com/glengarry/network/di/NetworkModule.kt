package com.glengarry.network.di

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.glengarry.network.BuildConfig
import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val coreNetworkModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor(get()))
            .build()
    }
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .client(get<OkHttpClient>())
            .build()
    }
}
