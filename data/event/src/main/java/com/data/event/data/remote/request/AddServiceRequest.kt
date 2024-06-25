package com.data.event.data.remote.request

import com.google.gson.annotations.SerializedName

data class AddServiceRequest(

	@field:SerializedName("whatsapp")
	val whatsapp: String? = null,

	@field:SerializedName("field")
	val field: String? = null,

	@field:SerializedName("logo")
	val logo: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("location")
	val location: String? = null,

	@field:SerializedName("detail")
	val detail: DetailServiceRequest? = null
)
