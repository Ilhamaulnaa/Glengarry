package com.data.event.di

import androidx.room.Room
import com.data.event.data.BookRepositoryImpl
import com.data.event.data.ElectronicRepositoryImpl
import com.data.event.data.FashionRepositoryImpl
import com.data.event.data.SportRepositoryImpl
import com.data.event.data.local.GlengarryDatabase
import com.data.event.data.remote.service.GlengarryService
import com.data.event.domain.interactor.BookInteractor
import com.data.event.domain.interactor.ElectronicInteractor
import com.data.event.domain.interactor.FashionInteractor
import com.data.event.domain.interactor.SportInteractor
import com.data.event.domain.repository.BookRepository
import com.data.event.domain.repository.ElectronicRepository
import com.data.event.domain.repository.FashionRepository
import com.data.event.domain.repository.SportRepository
import com.data.event.domain.usecase.BookUseCase
import com.data.event.domain.usecase.ElectronicUseCase
import com.data.event.domain.usecase.FashionUseCase
import com.data.event.domain.usecase.SportUseCase
import org.koin.dsl.module
import retrofit2.Retrofit

val dataEventModule = module {

    single {
        Room.databaseBuilder(
            context = get(),
            klass = GlengarryDatabase::class.java,
            name = GlengarryDatabase.DATABASE_NAME
        ).build()
    }

    single<GlengarryService> {
        get<Retrofit>().create(GlengarryService::class.java)
    }

    // Domain
//    single<AllEventServiceUseCase> { AllEventServiceInteractor(get()) }
    single<FashionUseCase> { FashionInteractor(get()) }
    single<ElectronicUseCase> { ElectronicInteractor(get()) }
    single<BookUseCase> { BookInteractor(get()) }
    single<SportUseCase> { SportInteractor(get()) }
//    single<RecommendationUseCase> { RecommendationInteractor(get()) }
//    single<SavedEventServiceUseCase> { SavedEventServiceInteractor(get()) }

    // Data
//    single<AllEventNeedRepository> { AllEventNeedRepositoryImpl(get()) }
    single<FashionRepository> { FashionRepositoryImpl(get()) }
    single<ElectronicRepository> { ElectronicRepositoryImpl(get()) }
    single<BookRepository> { BookRepositoryImpl(get()) }
    single<SportRepository> { SportRepositoryImpl(get()) }
//    single<RecommendationRepository> { RecommendationRepositoryImpl(get(), get()) }
//    single<SavedEventServiceRepository> { SavedEventServiceRepositoryImpl(get(), get()) }
}
