package com.data.user.data.remote.response

import com.google.gson.annotations.SerializedName

data class UpdateProfileImageResponse(
	@field:SerializedName("image_url")
	val imageUrl: String? = null
)
