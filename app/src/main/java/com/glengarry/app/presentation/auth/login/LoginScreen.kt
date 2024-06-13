package com.glengarry.app.presentation.auth.login

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.core.domain.model.Resource
import com.data.user.domain.model.UserPreferences
import com.dsc.form_builder.TextFieldState
import com.glengarry.app.R
import com.glengarry.app.ui.button.ButtonWithGoogle
import com.glengarry.app.ui.button.PrimaryButton
import com.glengarry.app.ui.dialog.BaseDialog
import com.glengarry.app.ui.dialog.BaseDialogButton
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.textfield.BaseLargeTextField
import com.glengarry.app.ui.textfield.BasePasswordTextField
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.theme.blue
import com.glengarry.app.ui.theme.darkBlue
import com.glengarry.app.ui.theme.grey
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = koinViewModel(),
    navigateToRegisterScreen: () -> Unit = {},
    navigateToMainScreen: () -> Unit = {},
    navigateForgotPassword: () -> Unit = {}
) {

    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val loginUiState by viewModel.loginUiState.collectAsStateWithLifecycle()
    val formState = remember { viewModel.formState }

    val email = formState.getState<TextFieldState>("email")
    val password = formState.getState<TextFieldState>("password")
    val loginResult = loginUiState.loginResult

    val buttonLoginLoading by viewModel.buttonLoginLoading.collectAsStateWithLifecycle(
        initialValue = false
    )

    var errorDialogMessage by remember {
        mutableStateOf("")
    }
    var showErrorDialog by remember {
        mutableStateOf(false)
    }
    var hideErrorDialog = { showErrorDialog = false }

//    var email by remember {
//        mutableStateOf("")
//    }
//    var password by remember {
//        mutableStateOf("")
//    }

    val onLoginClick: () -> Unit = fun() {
        if (!formState.validate()) return
        viewModel.login()
    }

    val onRegisterClick: () -> Unit = {
        viewModel.resetUpdateLoginResult()
        navigateToRegisterScreen()
    }

    val onSignUpWithGoogle: () -> Unit = {
       scope.launch {
           snackBarHostState.showSnackbar("Sign Up with Google not implement yet")
       }
    }

    LaunchedEffect(key1 = loginResult){
        if (loginResult is Resource.Error){
            errorDialogMessage = loginResult.message ?: "There is some error"
            showErrorDialog = true
            password.change("")
        }
        if (loginResult is Resource.Success){
            hideErrorDialog()
            val result = loginResult.data
            val userPreferences = UserPreferences(
                name = result.name,
                email = result.email,
                accessToken = result.accessToken,
                refreshToken = result.refreshToken
            )
            viewModel.updateLoggingPreferences(true)
            viewModel.updateUserPreferences(userPreferences)
            navigateToMainScreen()
        }
    }

    if(showErrorDialog){
        BaseDialog(
            message = errorDialogMessage,
            positiveButton = BaseDialogButton(
                title = "Oke",
                onClick = hideErrorDialog
            )
        )
    }

    Scaffold (
        modifier = modifier
            .navigationBarsPadding()
            .safeDrawingPadding()
    ) { _ ->
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxSize()
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.glengarry_logo),
                contentDescription = "logo",
                modifier = Modifier
                    .size(200.dp),
            )
            Spacer(modifier = Modifier.height(55.dp))
            BaseText(
                modifier = Modifier
                    .align(Alignment.Start),
                text = "Login",
                fontWeight = FontWeight.Medium,
                fontSize = 24.sp,
                color = darkBlue
            )
            BaseText(
                modifier = Modifier
                    .align(Alignment.Start),
                text = "Please login to your account",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = grey
            )

            Spacer(modifier = Modifier.height(35.dp))
            BaseLargeTextField(
                value = email.value,
                onValueChange = email::change,
                placeholder = "Email",
                isError = email.hasError,
                supportingText = email.errorMessage,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            Spacer(modifier = Modifier.height(19.dp))
            BasePasswordTextField(
                value = password.value,
                onValueChange = password::change,
                placeholder = "Password",
                isError = password.hasError,
                supportText = password.errorMessage
            )
            Row(
                modifier = Modifier
                    .padding(top = 6.dp)
                    .align(Alignment.Start),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                BaseText(
                    text = "Don't have an account?",
                    color = grey,
                    fontSize = 12.sp,
                )
                BaseText(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { onRegisterClick() },
                    text = "Register",
                    color = blue,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
                BaseText(
                    modifier = Modifier
                        .clickable { navigateForgotPassword() },
                    text = "Lupa password?",
                    color = blue,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(modifier = Modifier.height(26.dp))
            PrimaryButton(
                text = "Login",
                onClick = onLoginClick,
                loading = buttonLoginLoading,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(26.dp))
            LoginDivider()
            Spacer(modifier = Modifier.height(26.dp))
            ButtonWithGoogle(
                modifier = Modifier.fillMaxWidth(),
                onCLick = { onSignUpWithGoogle() }
            )
        }
    }
}

@Composable
fun LoginDivider(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        Spacer(modifier = Modifier.width(6.dp))
        BaseText(
            text = "or",
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.width(6.dp))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun LoginScreenPreview() {
    GlengarryTheme {
        Surface {
            LoginScreen()
        }
    }
}