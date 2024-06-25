package com.data.event.data.remote.response

import com.google.gson.annotations.SerializedName

data class AddServiceResponse(

	@field:SerializedName("data")
	val data: AddServiceData? = null,

	@field:SerializedName("id")
	val id: String? = null
)

data class AddServiceData(

	@field:SerializedName("whatsapp")
	val whatsapp: String? = null,

	@field:SerializedName("twitter")
	val twitter: String? = null,

	@field:SerializedName("website")
	val website: String? = null,

	@field:SerializedName("field")
	val field: String? = null,

	@field:SerializedName("logo_url")
	val logoUrl: String? = null,

	@field:SerializedName("line")
	val line: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("instagram")
	val instagram: String? = null,

//	@field:SerializedName("packages")
//	val packages: List<PackagesResponse>? = null,

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("location")
	val location: String? = null
)
