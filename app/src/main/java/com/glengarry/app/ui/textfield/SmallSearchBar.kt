package com.glengarry.app.ui.textfield

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.R
import com.glengarry.app.ui.theme.GlengarryTheme

@ExperimentalMaterial3Api
val smallTextFieldColors @Composable get() =  TextFieldDefaults.outlinedTextFieldColors(
    disabledBorderColor = Color.Transparent,
    unfocusedBorderColor = Color.Transparent,
    focusedBorderColor = Color(0xFF999999),
    containerColor = Color(0xFFF5F2F8)
)

val smallTextFieldStyle @Composable get() = MaterialTheme.typography.bodyMedium.copy(
    fontWeight = FontWeight.SemiBold,
    color = Color(0xFF999999),
    fontSize = 14.sp,
)

@ExperimentalMaterial3Api
@Composable
fun SmallSearchBar(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    colors: TextFieldColors = smallTextFieldColors,
    textStyle: TextStyle = smallTextFieldStyle,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    BaseOutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = textStyle,
        shape = RoundedCornerShape(10.dp),
        colors = colors,
        singleLine = true,
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
        modifier = modifier.height(40.dp),
        leadingIcon = {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )

            }
        },
        placeholder = {
            if (placeholder.isNotBlank()) {
                Text(
                    text = placeholder,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF999999),
                    fontSize = 14.sp,
                )
            }
        },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions
    )
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewSmallSearchBar() {
    GlengarryTheme {
        Surface {
            SmallSearchBar(
                value = "Search",
                onValueChange = {},
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}