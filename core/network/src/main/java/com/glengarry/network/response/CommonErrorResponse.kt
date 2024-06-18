package com.glengarry.network.response

import com.google.gson.annotations.SerializedName

data class CommonErrorResponse(

	@field:SerializedName("data")
	val data: Any? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)
