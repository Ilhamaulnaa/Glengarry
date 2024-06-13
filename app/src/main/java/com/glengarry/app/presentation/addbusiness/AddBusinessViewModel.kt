package com.glengarry.app.presentation.addbusiness

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.domain.model.Resource
import com.data.user.domain.model.RefreshTokenResult
import com.data.user.domain.model.UserPreferences
import com.data.user.domain.usecase.UserPreferencesUseCase
import com.data.user.domain.usecase.UserUseCase
import com.dsc.form_builder.FormState
import com.dsc.form_builder.TextFieldState
import com.dsc.form_builder.Validators
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class AddBusinessViewModel (
    private val userPreferenceUseCase: UserPreferencesUseCase,
    private val userUseCase: UserUseCase
): ViewModel() {

    val userPreference = MutableStateFlow(UserPreferences())
    val refreshTokenResult = MutableStateFlow<Resource<RefreshTokenResult>>(Resource.idle)

    fun getUserPreference() {
        viewModelScope.launch {
            userPreferenceUseCase.userPreference.collect { result ->
                userPreference.update { result }
            }
        }
    }

    fun getRefreshToken(refreshToken: String) {
        viewModelScope.launch {
            userUseCase.refreshToken(refreshToken).collect { result ->
                refreshTokenResult.update { result }
            }
        }
    }

    fun updateAccessToken(accessToken: String){
        viewModelScope.launch {
            userPreferenceUseCase.updateAccessToken(accessToken)
        }
    }

    val formState = FormState(
        fields = listOf(
            TextFieldState(
                name = "category",
                validators = listOf(Validators.Required())
            ),
            TextFieldState(
                name = "subcategory",
                validators = listOf(Validators.Required())
            ),
            TextFieldState(
                name = "location",
                validators = emptyList()
            ),
            TextFieldState(
                name = "business-name",
                validators = listOf(Validators.Required())
            ),
            TextFieldState(
                name = "business-email",
                validators = listOf(Validators.Required(), Validators.Email())
            ),
            TextFieldState(
                name = "whatsapp-number",
                validators = listOf(Validators.Required(), Validators.Phone())
            ),
            TextFieldState(
                name = "business-description",
                validators = listOf(Validators.Required())
            ),
            TextFieldState(
                name = "business-price",
                validators = listOf(Validators.Required())
            ),

        )
    )
}