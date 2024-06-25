package com.glengarry.network.response

import com.google.gson.annotations.SerializedName

data class CommonGetDataResponse<out T>(
    @field:SerializedName("data")
    val data: DataResponse<T>? = null,

    @field:SerializedName("success")
    val success: Boolean? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: Int? = null
)

data class DataResponse<out T>(

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("data")
    val data: T? = null,

    @field:SerializedName("limit")
    val limit: Int? = null,

    @field:SerializedName("total_page")
    val totalPage: Int? = null,

    @field:SerializedName("page")
    val page: Int? = null

)
