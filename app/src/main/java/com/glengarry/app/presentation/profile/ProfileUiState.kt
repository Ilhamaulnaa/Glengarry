package com.glengarry.app.presentation.profile

import com.core.domain.model.Resource
import com.data.user.domain.model.User

data class ProfileUiState(
    val user: Resource<User> = Resource.idle
)