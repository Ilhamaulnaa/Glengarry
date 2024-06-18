package com.glengarry.network.response

import com.google.gson.annotations.SerializedName

data class CommonBaseResponse<out T>(
    @field:SerializedName("data")
    val data: T? = null,

    @field:SerializedName("success")
    val success: Boolean? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: Int? = null
)