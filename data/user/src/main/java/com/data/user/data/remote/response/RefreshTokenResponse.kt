package com.data.user.data.remote.response

import com.google.gson.annotations.SerializedName

data class RefreshTokenResponse(

    @field:SerializedName("access_token")
    val accessToken: String? = null
)