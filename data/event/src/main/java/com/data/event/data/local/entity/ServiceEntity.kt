package com.data.event.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.core.domain.model.ServiceLocalType
import com.core.domain.model.ServiceType

@Entity
data class ServiceEntity(
    @PrimaryKey
    val id: String = "",
    val logo: String = "",
    val title: String = "",
    val serviceType: String = "",
    val field: String = "",
    val minPrice: Double = 0.0,
    val rating: Double = 0.0,
    val type: ServiceType = ServiceType.ELECTRONIC,
    val localType: ServiceLocalType = ServiceLocalType.Recommendation
)
