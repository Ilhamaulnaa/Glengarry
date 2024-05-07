package com.glengarry.app.ui.textfield

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.theme.grey

@ExperimentalMaterial3Api
val largeTextFieldColors @Composable get() = TextFieldDefaults.outlinedTextFieldColors(
    disabledBorderColor = Color.Transparent,
    unfocusedBorderColor = Color(0xFF0A4A4A4),
    focusedBorderColor = Color.Black,
    containerColor = Color.Transparent
)

val largeTextFieldStyle @Composable get() = MaterialTheme.typography.bodyMedium.copy(
    fontWeight = FontWeight.SemiBold,
    color = Color.Black.copy(0.7f),
    fontSize = 14.sp
)

@ExperimentalMaterial3Api
@Composable
fun BaseLargeTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    label: String = "",
    isError: Boolean = false,
    supportingText: String = "",
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    colors: androidx.compose.material3.TextFieldColors = largeTextFieldColors,
    textStyle: TextStyle = largeTextFieldStyle

) {

    Column(modifier = modifier) {
        BaseOutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = textStyle,
            shape = RoundedCornerShape(12.dp),
            colors = colors,
            singleLine = true,
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 14.dp),
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(),
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = isError,
            placeholder = {
                if (placeholder.isNotBlank()) {
                    Text(
                        text = placeholder,
                        color = grey,
                        fontSize = 14.sp,
                    )
                }
            }
        )
        AnimatedVisibility(visible = supportingText.isNotEmpty()) {
            BaseText(
                text = supportingText,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun BaseLargeTextFieldPreview() {
    GlengarryTheme {
        Surface {
            BaseLargeTextField(
                value = "Search",
                onValueChange = {},
                label = "Search",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
