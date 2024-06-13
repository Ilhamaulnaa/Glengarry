package com.glengarry.app.presentation.auth.login

import com.core.domain.model.Resource
import com.data.user.domain.model.LoginResult

data class LoginUiState(
    val loginResult: Resource<LoginResult> = Resource.idle
)