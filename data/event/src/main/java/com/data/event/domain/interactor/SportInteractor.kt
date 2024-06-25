package com.data.event.domain.interactor

import androidx.paging.PagingData
import com.core.domain.model.AddServiceResult
import com.core.domain.model.Resource
import com.core.domain.model.ServiceDetail
import com.core.domain.model.ServiceItem
import com.data.event.domain.repository.BookRepository
import com.data.event.domain.repository.ElectronicRepository
import com.data.event.domain.repository.FashionRepository
import com.data.event.domain.repository.SportRepository
import com.data.event.domain.usecase.BookUseCase
import com.data.event.domain.usecase.ElectronicUseCase
import com.data.event.domain.usecase.FashionUseCase
import com.data.event.domain.usecase.SportUseCase
import kotlinx.coroutines.flow.Flow

class SportInteractor(
    private val repository: SportRepository
) : SportUseCase {

    override fun getSportById(id: String): Flow<Resource<ServiceDetail>> {
        return repository.getSportById(id)
    }

    override fun getRecommendationSport(
        accessToken: String,
        id: String
    ): Flow<Resource<List<ServiceItem>>> {
        return repository.getRecommendationSport(accessToken, id)
    }

    override fun getSport(): Flow<PagingData<ServiceItem>> {
        return repository.getSport()
    }

    override fun searchSportNeeds(
        name: String,
        field: List<String>,
        fees: String
    ): Flow<PagingData<ServiceItem>> {
        return repository.searchSportNeeds(name, field, fees)
    }

    override fun addSport(
        accessToken: String,
        name: String,
        field: String,
        email: String,
        whatsapp: String,
        logo: String,
        location: String,
        description: String,
        price: Double
    ): Flow<Resource<AddServiceResult>> {
        return repository.addSport(
            accessToken = accessToken,
            name = name,
            field = field,
            description = description,
            email = email,
            whatsapp = whatsapp,
            logo = logo,
            location = location,
            price = price
        )
    }



}