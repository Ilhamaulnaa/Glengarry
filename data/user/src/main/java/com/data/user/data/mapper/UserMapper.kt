package com.data.user.data.mapper

import com.data.user.data.remote.response.UserResponse
import com.data.user.domain.model.User

fun UserResponse.toDomain(): User {
    return User(
        dob = dob ?: "",
        createdAt = createdAt ?: "",
        phoneNumber = phoneNumber ?: "",
        location = location ?: "",
        id = id ?: "",
        photoUrl = photoUrl ?: "",
        displayName = displayName ?: "",
        email = email ?: "",
        lastSignIn = lastSignIn ?: ""
    )
}