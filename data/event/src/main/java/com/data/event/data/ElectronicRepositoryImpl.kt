package com.data.event.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.core.domain.model.AddServiceResult
import com.core.domain.model.Resource
import com.core.domain.model.ServiceDetail
import com.core.domain.model.ServiceItem
import com.core.domain.model.ServiceType
import com.data.event.data.mapper.toDomain
import com.data.event.data.mapper.toDomains
import com.data.event.data.paging.ServicePagingSource
import com.data.event.data.remote.request.AddServiceRequest
import com.data.event.data.remote.service.GlengarryService
import com.data.event.domain.repository.ElectronicRepository
import com.haroldadmin.cnradapter.NetworkResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class ElectronicRepositoryImpl(
    private val service: GlengarryService
) : ElectronicRepository {

    override fun getElectronicById(id: String): Flow<Resource<ServiceDetail>> = flow<Resource<ServiceDetail>> {
        emit(Resource.Loading)
        when (val response = service.getElectronicById(id)){
            is NetworkResponse.Success -> {
                val result = response.body.data?.toDomain()
                if (result == null){
                    emit(Resource.Error(message = "Data Null"))
                    return@flow
                }
                emit(Resource.Success(result))
            }
            is NetworkResponse.Error -> {
                val message = response.error?.message ?: response.error?.message
                emit(Resource.Error(message = message))
            }
        }
    }.catch {
        emit(Resource.Error(message = it.message))
    }

    override fun getRecommendationElectronic(
        accessToken: String,
        id: String
    ): Flow<Resource<List<ServiceItem>>> = flow{
        emit(Resource.Loading)
        val authToken = "bearer $accessToken"
        when (val response = service.getRecommendationElectronic(id,authToken)){
            is NetworkResponse.Success -> {
                val result = response.body.data?.toDomains(type = ServiceType.ELECTRONIC) ?: emptyList()
                emit(Resource.Success(result))
            }
            is NetworkResponse.Error -> {
                val message = response.error?.message ?: response.error?.message
                emit(Resource.Error(message = message))
            }
        }
    }

    override fun getElectronic(): Flow<PagingData<ServiceItem>> {
        return Pager(
            config = PagingConfig(pageSize = ServicePagingSource.DEFAULT_SIZE),
            pagingSourceFactory = { ServicePagingSource(service = service, type = ServiceType.ELECTRONIC)}
        ).flow
    }

    override fun searchElectronicNeeds(
        name: String,
        field: List<String>,
        fees: String
    ): Flow<PagingData<ServiceItem>> {
        return Pager(
            config = PagingConfig(pageSize = ServicePagingSource.DEFAULT_SIZE),
            pagingSourceFactory = { ServicePagingSource(service = service, name = name, field = field, fees = fees, type = ServiceType.ELECTRONIC)}
        ).flow
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
    ): Flow<Resource<AddServiceResult>> = flow<Resource<AddServiceResult>> {
        emit(Resource.Loading)
        val authToken = "barier $accessToken"
//        val detail = DetailServiceRequest(
//            steps = steps,
//            stepsAfter = stepsAfter,
//            about = about,
//            value = value
//        )
        val request = AddServiceRequest(
            name = name,
            whatsapp = whatsapp,
            field = field,
            email = email,
            logo = logo,
        )
        val response = service.addElectronic(
            authorization = authToken,
            request = request
        )
        when(response) {
            is NetworkResponse.Success -> {
                val result = response.body.data?.toDomain()
                if (result == null){
                    emit(Resource.Error(message = "Data null"))
                    return@flow
                }
            }
            is NetworkResponse.Error -> {
                val message = response.error?.message ?: response.error?.message
                emit(Resource.Error(message = message))
            }
        }
    }.catch {
        emit(Resource.Error(message = it.message))
    }
}