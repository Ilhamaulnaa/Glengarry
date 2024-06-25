package com.data.event.domain.usecase

import androidx.paging.PagingData
import com.core.domain.model.AddServiceResult
import com.core.domain.model.Resource
import com.core.domain.model.ServiceDetail
import com.core.domain.model.ServiceItem
import kotlinx.coroutines.flow.Flow

interface ElectronicUseCase {

    fun getElectronicById(
        id: String
    ): Flow<Resource<ServiceDetail>>

    fun getRecommendationElectronic(
        accessToken: String,
        id: String
    ): Flow<Resource<List<ServiceItem>>>

    fun getElectronic(): Flow<PagingData<ServiceItem>>

    fun searchElectronicNeeds(
        name: String,
        field: List<String> = emptyList(),
        fees: String = ""
    ): Flow<PagingData<ServiceItem>>


    fun addElectronic(
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
//    ): Flow<Resource<EventServiceDetail>>

}