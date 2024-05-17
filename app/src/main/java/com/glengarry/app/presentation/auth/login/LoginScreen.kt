package com.glengarry.app.presentation.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.R
import com.glengarry.app.ui.button.ButtonWithGoogle
import com.glengarry.app.ui.button.PrimaryButton
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.textfield.BaseLargeTextField
import com.glengarry.app.ui.textfield.BasePasswordTextField
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.theme.blue
import com.glengarry.app.ui.theme.darkBlue
import com.glengarry.app.ui.theme.grey
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun LoginScreen(
    navigateToRegisterScreen: () -> Unit = {},
    navigateToMainScreen: () -> Unit = {},
    navigateForgotPassword: () -> Unit = {}
) {

    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    val onSignUpWithGoogle: () -> Unit = {
       scope.launch {
           snackBarHostState.showSnackbar("Sign Up with Google not implement yet")
       }
    }

    Column(
        modifier = Modifier.padding(20.dp),
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
            value = email,
            onValueChange = { email = it },
            placeholder = "Email"
        )
        Spacer(modifier = Modifier.height(19.dp))
        BasePasswordTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = "Password"
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
                    .clickable { navigateToRegisterScreen() },
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
            onClick = { navigateToMainScreen() },
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