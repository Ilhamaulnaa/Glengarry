package com.data.event.data.mapper

import com.core.domain.model.ServiceDetail
import com.data.event.data.remote.response.ServiceDetailResponse

fun ServiceDetailResponse.toDomain(): ServiceDetail {
    return ServiceDetail(
        whatsapp = whatsapp ?: "",
        lastUpdated = lastUpdated ?: "",
        isActive = isActive ?: false,
        logoUrl = logoUrl ?: "",
        description = description ?: "",
        createdAt = createdAt ?: "",
        createdBy = createdBy ?: "",
        approvedBy = approvedBy ?: "",
        field = field ?: "",
        isApproved = isApproved ?: false,
        isArchived = isArchived ?: false,
//        reviews = reviews?.map { it.toDomain() } ?: emptyList(),
        name = name ?: "",
        updatedBy = updatedBy ?: "",
        location = location ?: "",
        id = id ?: "",
        value = value ?: "",
        email = email ?: "",
        averageRating = averageRating ?: 0.0,
        reviewSentiment = reviewSentiment ?: "",
    )
}
