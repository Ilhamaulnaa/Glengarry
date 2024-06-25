package com.data.event.domain.interactor

import androidx.paging.PagingData
import com.core.domain.model.AddServiceResult
import com.core.domain.model.Resource
import com.core.domain.model.ServiceDetail
import com.core.domain.model.ServiceItem
import com.data.event.domain.repository.FashionRepository
import com.data.event.domain.usecase.FashionUseCase
import kotlinx.coroutines.flow.Flow

class FashionInteractor(
    private val repository: FashionRepository
) : FashionUseCase {

    override fun getFashionById(id: String): Flow<Resource<ServiceDetail>> {
        return repository.getFashionById(id)
    }

    override fun getRecommendationFashion(
        accessToken: String,
        id: String
    ): Flow<Resource<List<ServiceItem>>> {
        return repository.getRecommendationFashion(accessToken, id)
    }

    override fun getFashion(): Flow<PagingData<ServiceItem>> {
        return repository.getFashion()
    }

    override fun searchFashionNeeds(
        name: String,
        field: List<String>,
        fees: String
    ): Flow<PagingData<ServiceItem>> {
        return repository.searchFashionNeeds(name, field, fees)
    }

    override fun addFashion(
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
        return repository.addFashion(
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