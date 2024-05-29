package com.core.domain.model

import android.media.Rating


enum class ServiceType{
    FASHION, ELECTRONIC, BOOK, SPORT
}
data class ServiceItem(
    val id: String = "",
    val logo: String = "",
    val title: String = "",
    val rating: Double = 0.0,
    val minPrice: Double = 0.0,
    val serviceType: String = "",
    val type: ServiceType = ServiceType.SPORT
)