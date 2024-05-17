package com.glengarry.app.presentation.auth.forgotpassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.R
import com.glengarry.app.presentation.auth.login.LoginDivider
import com.glengarry.app.ui.button.ButtonWithGoogle
import com.glengarry.app.ui.button.PrimaryButton
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.textfield.BaseLargeTextField
import com.glengarry.app.ui.textfield.BasePasswordTextField
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.theme.blue
import com.glengarry.app.ui.theme.darkBlue
import com.glengarry.app.ui.theme.grey

@ExperimentalMaterial3Api
@Composable
fun ForgotPasswordScreen() {
    var email by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
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
            text = "Forgot \nPassword?",
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp,
            color = darkBlue
        )
        BaseText(
            modifier = Modifier
                .align(Alignment.Start),
            text = "No worries! We will help You reset and remember it again",
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
        Spacer(modifier = Modifier.height(26.dp))
        PrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Continues",
            onClick = {},
        )
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun ForgotPasswordScreenPreview() {
    GlengarryTheme {
        Surface {
            ForgotPasswordScreen()
        }
    }
}