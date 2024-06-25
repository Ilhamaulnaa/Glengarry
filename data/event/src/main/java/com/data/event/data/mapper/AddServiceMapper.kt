package com.data.event.data.mapper

import com.core.domain.model.AddServiceResult
import com.data.event.data.remote.response.AddServiceResponse

fun AddServiceResponse.toDomain(): AddServiceResult {
    val data = data
    return AddServiceResult(
        id = id ?: "",
        whatsapp = data?.whatsapp ?: "",
        field = data?.field ?: "",
        logoUrl = data?.logoUrl ?: "",
        name = data?.name ?: "",
        description = data?.description ?: "",
        value = data?.value ?: "",
        email = data?.email ?: "",
        location = data?.location ?: "",
//        packages = data?.packages?.toDomains() ?: emptyList(),
    )
}
