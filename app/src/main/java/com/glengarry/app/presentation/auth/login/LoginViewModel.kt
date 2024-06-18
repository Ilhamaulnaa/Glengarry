package com.glengarry.app.presentation.auth.login

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.domain.model.Resource
import com.data.user.domain.model.UserPreferences
import com.data.user.domain.usecase.SettingsPreferenceUseCase
import com.data.user.domain.usecase.UserPreferencesUseCase
import com.data.user.domain.usecase.UserUseCase
import com.dsc.form_builder.FormState
import com.dsc.form_builder.TextFieldState
import com.dsc.form_builder.Validators
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel (

    private val loginUseCase: UserUseCase,
    private val userPreferencesUseCase: UserPreferencesUseCase,
    private val settingsPreferenceUseCase: SettingsPreferenceUseCase

): ViewModel() {

    private val _loginUiState = MutableStateFlow(LoginUiState())
    val loginUiState: StateFlow<LoginUiState> get() = _loginUiState

    val formState = FormState(
        fields = listOf(
            TextFieldState(
                name = "email",
                validators = listOf(Validators.Email(), Validators.Required())
            ),
            TextFieldState(
                name = "password",
                validators = listOf(Validators.Min(limit = 6, message = "Min Password 6 character"), Validators.Required())
            )
        )
    )

    val buttonLoginLoading get() = _loginUiState.map {
        it.loginResult is Resource.Loading || it.loginResult is Resource.Success
    }

    fun login(){
        viewModelScope.launch {
            val email = formState.getState<TextFieldState>("email").value
            val password = formState.getState<TextFieldState>("password").value
            loginUseCase.login(email, password).collect { result ->
                _loginUiState.update {
                    it.copy(loginResult = result)
                }
            }
        }
    }

    fun updateUserPreferences(userPreferences: UserPreferences){
        viewModelScope.launch {
            userPreferencesUseCase.updateUserPreferences(userPreferences)
        }
    }

    fun updateLoggingPreferences(state: Boolean){
        viewModelScope.launch {
            settingsPreferenceUseCase.setLoginState(state)
        }
    }

    fun resetUpdateLoginResult(){
        _loginUiState.update {
            it.copy(loginResult = Resource.idle)
        }
    }

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}