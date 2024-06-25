package com.data.event.domain.repository

import androidx.paging.PagingData
import com.core.domain.model.AddServiceResult
import com.core.domain.model.Resource
import com.core.domain.model.ServiceDetail
import com.core.domain.model.ServiceItem
import kotlinx.coroutines.flow.Flow

interface BookRepository {

    fun getBookById(
        id: String
    ): Flow<Resource<ServiceDetail>>

    fun getRecommendationBook(
        accessToken: String,
        id: String
    ): Flow<Resource<List<ServiceItem>>>

    fun getBook(): Flow<PagingData<ServiceItem>>

    fun searchBookNeeds(
        name: String,
        field: List<String>,
        fees: String
    ): Flow<PagingData<ServiceItem>>

    fun addBook(
        accessToken: String,
        name: String,
        field: String,
        email: String,
        whatsapp: String,
        logo: String,
        location: String,
        description: String,
        price: Double
    ): Flow<Resource<AddServiceResult>>

//    fun getMediaPartnerDetail(
//        steps: List<String>,
//        stepsAfter: List<String>,
//        value: List<String>,
//        about: String,
//    ): Flow<Resource<ServiceDetail>>
}