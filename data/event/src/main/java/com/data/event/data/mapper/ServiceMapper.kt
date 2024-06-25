package com.data.event.data.mapper

import com.core.domain.model.ServiceItem
import com.core.domain.model.ServiceLocalType
import com.core.domain.model.ServiceType
import com.data.event.data.local.entity.ServiceEntity
import com.data.event.data.remote.response.ServiceResponse

@JvmName("serviceResponsesToDomains")
fun List<ServiceResponse>.toDomains(type: ServiceType): List<ServiceItem> {
    return map { it.toDomain(type) }
}

@JvmName("serviceResponseToDomain")
fun ServiceResponse.toDomain(type: ServiceType): ServiceItem {
    val eventServiceType = when  {
        serviceType?.contains("fashion") == true -> ServiceType.FASHION
        serviceType?.contains("electronic") == true -> ServiceType.ELECTRONIC
        serviceType?.contains("book") == true -> ServiceType.BOOK
        serviceType?.contains("sport") == true -> ServiceType.SPORT
        else -> type
    }
    val serviceTypeUi = when (eventServiceType)  {
        ServiceType.FASHION -> "Fashion"
        ServiceType.ELECTRONIC -> "Sponsor"
        ServiceType.BOOK -> "book"
        else -> "sport"
    }
    return ServiceItem(
        id = id ?: "",
        logo = logoUrl ?: "",
        title = name ?: "",
        serviceType = serviceTypeUi,
        field = field ?: "",
        minPrice = minPrice ?: 0.0,
        rating = averageRating?.toDoubleOrNull() ?: 0.0,
        type = eventServiceType
    )
}


@JvmName("serviceResponsesToEntities")
fun List<ServiceResponse>.toEntities(localType: ServiceLocalType): List<ServiceEntity> {
    return map { it.toEntity(localType) }
}

@JvmName("serviceResponseToEntity")
fun ServiceResponse.toEntity(localType: ServiceLocalType): ServiceEntity {
    val type = when  {
        serviceType?.contains("media") == true -> ServiceType.FASHION
        serviceType?.contains("electronic") == true -> ServiceType.ELECTRONIC
        serviceType?.contains("book") == true -> ServiceType.BOOK
        else -> ServiceType.SPORT
    }
    val serviceTypeUi = when  {
        serviceType?.contains("fashion") == true -> "Fashion"
        serviceType?.contains("electronic") == true -> "electronic"
        serviceType?.contains("book") == true -> "Book"
        else -> "Sport"
    }
    return ServiceEntity(
        id = id ?: "",
        logo = logoUrl ?: "",
        title = name ?: "",
        serviceType = serviceTypeUi,
        field = field ?: "",
        minPrice = minPrice ?: 0.0,
        rating = averageRating?.toDoubleOrNull() ?: 0.0,
        type = type,
        localType = localType
    )
}

@JvmName("serviceEntitiesToDomains")
fun List<ServiceEntity>.toDomains(): List<ServiceItem> {
    return map { it.toDomain() }
}

@JvmName("serviceEntityToDomain")
fun ServiceEntity.toDomain(): ServiceItem {
    return ServiceItem(
        id = id,
        logo = logo,
        title = title,
        serviceType = serviceType,
        field = field,
        minPrice = minPrice,
        rating = rating,
        type = type
    )
}
