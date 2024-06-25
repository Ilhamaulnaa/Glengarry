package com.glengarry.app.presentation.addbusiness

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.common.PrefixUtils
import com.core.domain.model.AddServiceResult
import com.core.domain.model.Resource
import com.core.domain.model.ServiceType
import com.data.event.domain.usecase.BookUseCase
import com.data.event.domain.usecase.ElectronicUseCase
import com.data.event.domain.usecase.FashionUseCase
import com.data.event.domain.usecase.SportUseCase
import com.data.user.domain.model.RefreshTokenResult
import com.data.user.domain.model.UserPreferences
import com.data.user.domain.usecase.UserPreferencesUseCase
import com.data.user.domain.usecase.UserUseCase
import com.dsc.form_builder.FormState
import com.dsc.form_builder.TextFieldState
import com.dsc.form_builder.Validators
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class AddBusinessViewModel (
    private val userPreferenceUseCase: UserPreferencesUseCase,
    private val userUseCase: UserUseCase,
    private val fashionUseCase: FashionUseCase,
    private val electronicUseCase: ElectronicUseCase,
    private val bookUseCase: BookUseCase,
    private val sportUseCase: SportUseCase
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
                validators = listOf(Validators.Required())
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
                name = "confirm-email",
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

    val addServiceResult = MutableStateFlow<Resource<AddServiceResult>>(Resource.idle)
    val buttonLoading get() = addServiceResult.map { it is Resource.Loading }

    fun addService(
        type: ServiceType,
        accessToken: String,
        logo: String = ""
    ){
        val name = formState.getState<TextFieldState>("business-name").value
        val field = formState.getState<TextFieldState>("subcategory").value
        val location = formState.getState<TextFieldState>("location").value
        val description = formState.getState<TextFieldState>("business-description").value
        val email = formState.getState<TextFieldState>("business-email").value
        val whatsapp = formState.getState<TextFieldState>("whatsapp-number").value
        val price = formState.getState<TextFieldState>("business-price").value.toDoubleOrNull() ?: 0.0

        viewModelScope.launch {
            if (type == ServiceType.FASHION){
                fashionUseCase.addFashion(
                    accessToken = accessToken,
                    name = name,
                    email = email,
                    whatsapp = PrefixUtils.PHONE + whatsapp,
                    logo = logo,
                    location = location,
                    description = description,
                    field = field,
                    price = price
                ).collect { result ->
                    addServiceResult.update { result }
                }
                return@launch
            }
            if (type == ServiceType.ELECTRONIC){
                electronicUseCase.addElectronic(
                    accessToken = accessToken,
                    name = name,
                    email = email,
                    whatsapp = PrefixUtils.PHONE + whatsapp,
                    logo = logo,
                    location = location,
                    description = description,
                    field = field,
                    price = price
                ).collect { result ->
                    addServiceResult.update { result }
                }
            }
            if (type == ServiceType.BOOK){
                bookUseCase.addBook(
                    accessToken = accessToken,
                    name = name,
                    email = email,
                    whatsapp = PrefixUtils.PHONE + whatsapp,
                    logo = logo,
                    location = location,
                    description = description,
                    field = field,
                    price = price
                ).collect { result ->
                    addServiceResult.update { result }
                }
            }
            if (type == ServiceType.SPORT){
                sportUseCase.addSport(
                    accessToken = accessToken,
                    name = name,
                    email = email,
                    whatsapp = PrefixUtils.PHONE + whatsapp,
                    logo = logo,
                    location = location,
                    description = description,
                    field = field,
                    price = price
                ).collect { result ->
                    addServiceResult.update { result }
                }
            }
        }

    }

}