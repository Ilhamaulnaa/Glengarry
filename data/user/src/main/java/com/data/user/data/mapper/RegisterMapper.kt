package com.data.user.data.mapper

import com.data.user.data.remote.response.RegisterResponse
import com.data.user.domain.model.RegisterResult

fun RegisterResponse.toDomain(): RegisterResult {
    return RegisterResult(
        email = email ?: ""
    )
}