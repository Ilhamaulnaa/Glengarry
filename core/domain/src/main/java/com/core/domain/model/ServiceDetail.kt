package com.core.domain.model

data class ServiceDetail(

    val whatsapp: String = "",

    val lastUpdated: String = "",

    val isActive: Boolean = false,

    val logoUrl: String = "",

    val description: String = "",

    val createdAt: String = "",

    val createdBy: String = "",

    val approvedBy: String = "",

    val serviceType: String = "",

    val field: String = "",

    val isArchived: Boolean = false,

//    val reviews: List<ReviewsItem> = emptyList(),

    val name: String = "",

    val updatedBy: String = "",

    val isApproved: Boolean = false,

    val location: String = "",

    val id: String = "",

    val value: String = "",

    val email: String = "",

    val averageRating: Double,

    val reviewSentiment: String = "",

    val minPrice: Double = 0.0,

    val steps: List<String> = emptyList(),

    val stepAfter: List<String> = emptyList(),

    val about: String = "",

    val detailValue: List<String> = emptyList()
)
