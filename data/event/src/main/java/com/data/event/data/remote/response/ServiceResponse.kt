package com.data.event.data.remote.response

import com.google.gson.annotations.SerializedName

data class ServiceResponse(

    @field:SerializedName("service_type")
    val serviceType: String? = null,

    @field:SerializedName("whatsapp")
    val whatsapp: String? = null,

    @field:SerializedName("last_updated")
    val lastUpdated: String? = null,

    @field:SerializedName("is_active")
    val isActive: Boolean? = null,

    @field:SerializedName("logo_url")
    val logoUrl: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("average_rating")
    val averageRating: String? = null,

    @field:SerializedName("created_by")
    val createdBy: String? = null,

    @field:SerializedName("approved_by")
    val approvedBy: String? = null,

    @field:SerializedName("field")
    val field: String? = null,

    @field:SerializedName("is_archived")
    val isArchived: Boolean? = null,

    @field:SerializedName("min_price")
    val minPrice: Double? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("updated_by")
    val updatedBy: String? = null,

    @field:SerializedName("is_approved")
    val isApproved: Boolean? = null,

    @field:SerializedName("location")
    val location: Any? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("value")
    val value: String? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("steps")
    val steps: List<String>? = null,

    @field:SerializedName("steps_after")
    val stepAfter: List<String>? = null,

    @field:SerializedName("about")
    val about: String? = null,

    @field:SerializedName("detail_value")
    val detailValue: List<String>? = null
)
