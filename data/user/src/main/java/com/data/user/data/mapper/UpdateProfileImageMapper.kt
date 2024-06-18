package com.data.user.data.mapper

import com.data.user.data.remote.response.UpdateProfileImageResponse
import com.data.user.domain.model.UpdateProfileImageResult

fun UpdateProfileImageResponse.toDomain(): UpdateProfileImageResult {
    return UpdateProfileImageResult(
        imageUrl = imageUrl ?: ""
    )
}
