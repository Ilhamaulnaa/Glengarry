package com.data.user.data.mapper

import com.data.user.data.remote.response.LoginResponse
import com.data.user.domain.model.LoginResult

fun LoginResponse.toDomain(): LoginResult {
    return LoginResult(
        accessToken = accessToken ?: "",
        refreshToken = refreshToken ?: "",
        name = name ?: "",
        email = email ?: ""
    )
}