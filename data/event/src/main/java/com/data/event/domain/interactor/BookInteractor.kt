package com.data.event.domain.interactor

import androidx.paging.PagingData
import com.core.domain.model.AddServiceResult
import com.core.domain.model.Resource
import com.core.domain.model.ServiceDetail
import com.core.domain.model.ServiceItem
import com.data.event.domain.repository.BookRepository
import com.data.event.domain.repository.ElectronicRepository
import com.data.event.domain.repository.FashionRepository
import com.data.event.domain.usecase.BookUseCase
import com.data.event.domain.usecase.ElectronicUseCase
import com.data.event.domain.usecase.FashionUseCase
import kotlinx.coroutines.flow.Flow

class BookInteractor(
    private val repository: BookRepository
) : BookUseCase {

    override fun getBookById(id: String): Flow<Resource<ServiceDetail>> {
        return repository.getBookById(id)
    }

    override fun getRecommendationBook(
        accessToken: String,
        id: String
    ): Flow<Resource<List<ServiceItem>>> {
        return repository.getRecommendationBook(accessToken, id)
    }

    override fun getBook(): Flow<PagingData<ServiceItem>> {
        return repository.getBook()
    }

    override fun searchBookNeeds(
        name: String,
        field: List<String>,
        fees: String
    ): Flow<PagingData<ServiceItem>> {
        return repository.searchBookNeeds(name, field, fees)
    }

    override fun addBook(
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
        return repository.addBook(
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