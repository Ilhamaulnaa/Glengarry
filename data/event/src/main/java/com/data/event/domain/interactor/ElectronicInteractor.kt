package com.data.event.domain.interactor

import androidx.paging.PagingData
import com.core.domain.model.AddServiceResult
import com.core.domain.model.Resource
import com.core.domain.model.ServiceDetail
import com.core.domain.model.ServiceItem
import com.data.event.domain.repository.ElectronicRepository
import com.data.event.domain.repository.FashionRepository
import com.data.event.domain.usecase.ElectronicUseCase
import com.data.event.domain.usecase.FashionUseCase
import kotlinx.coroutines.flow.Flow

class ElectronicInteractor(
    private val repository: ElectronicRepository
) : ElectronicUseCase {

    override fun getElectronicById(id: String): Flow<Resource<ServiceDetail>> {
        return repository.getElectronicById(id)
    }

    override fun getRecommendationElectronic(
        accessToken: String,
        id: String
    ): Flow<Resource<List<ServiceItem>>> {
        return repository.getRecommendationElectronic(accessToken, id)
    }

    override fun getElectronic(): Flow<PagingData<ServiceItem>> {
        return repository.getElectronic()
    }

    override fun searchElectronicNeeds(
        name: String,
        field: List<String>,
        fees: String
    ): Flow<PagingData<ServiceItem>> {
        return repository.searchElectronicNeeds(name, field, fees)
    }

    override fun addElectronic(
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
        return repository.addElectronic(
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