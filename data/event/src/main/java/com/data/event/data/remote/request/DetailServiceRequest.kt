package com.data.event.data.remote.request

import com.google.gson.annotations.SerializedName

data class DetailServiceRequest(

	@field:SerializedName("steps_after")
	val stepsAfter: List<String>? = null,

	@field:SerializedName("about")
	val about: String? = null,

	@field:SerializedName("steps")
	val steps: List<String>? = null,

	@field:SerializedName("value")
	val value: List<String>? = null
)
