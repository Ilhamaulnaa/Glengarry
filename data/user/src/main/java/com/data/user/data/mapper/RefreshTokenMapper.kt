package com.data.user.data.mapper

import com.data.user.data.remote.response.RefreshTokenResponse
import com.data.user.domain.model.RefreshTokenResult

fun RefreshTokenResponse.toDomain(): RefreshTokenResult {
    return RefreshTokenResult(
        accessToken = accessToken ?: ""
    )
}