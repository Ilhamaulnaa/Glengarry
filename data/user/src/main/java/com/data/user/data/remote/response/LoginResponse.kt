package com.data.user.data.remote.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @field:SerializedName("access_token")
    val accessToken: String? = null,

    @field:SerializedName("refresh_token")
    val refreshToken: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("email")
    val email: String? = null
)
