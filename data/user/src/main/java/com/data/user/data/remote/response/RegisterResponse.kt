package com.data.user.data.remote.response

import com.google.gson.annotations.SerializedName

data class RegisterResponse(

    @field:SerializedName("email")
    val email: String? = null
)
