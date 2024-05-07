package com.glengarry.app.presentation.auth.register

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
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.R
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
fun RegisterScreen() {

    var username by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var confirmPassword by remember {
        mutableStateOf("")
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
                .size(200.dp)
        )
        Spacer(modifier = Modifier.height(55.dp))
        BaseText(
            modifier = Modifier
                .align(Alignment.Start),
            text = "Register",
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = darkBlue
        )
        BaseText(
            modifier = Modifier
                .align(Alignment.Start),
            text = "Please enter details to register",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = grey
        )
        Spacer(modifier = Modifier.height(55.dp))
        BaseLargeTextField(
            value = username,
            onValueChange = { username = it },
            placeholder = "Username",
        )
        Spacer(modifier = Modifier.height(10.dp))
        BaseLargeTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = "Email",
        )
        Spacer(modifier = Modifier.height(10.dp))
        BasePasswordTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = "Password"
        )
        Spacer(modifier = Modifier.height(10.dp))
        BasePasswordTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            placeholder = "Password"
        )
        Spacer(modifier = Modifier.height(28.dp))
        PrimaryButton(
            text = "Register",
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .padding(top = 6.dp)
                .align(Alignment.Start),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            BaseText(
                text = "Have an account already? ",
                color = grey,
                fontSize = 12.sp,
            )
            BaseText(
                modifier = Modifier
                    .clickable { },
                text = "Login",
                color = blue,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
    
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun RegisterScreenPreview() {
    GlengarryTheme {
        Surface {
            RegisterScreen()
        }
    }
}