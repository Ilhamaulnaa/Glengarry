package com.glengarry.app.ui.textfield

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.theme.poppinsFontFamily

@ExperimentalMaterial3Api
@Composable
fun HightTextFieldWithLabel(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    placeholder: String = "",
    label: String = "",
    isError: Boolean = false,
    maxLenght: Int? = null,
    minLines: Int = 1,
    maxLines: Int = minLines,
    supportingText: String = "",
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    colors: androidx.compose.material3.TextFieldColors = largeTextFieldColors,
    textStyle: TextStyle = largeTextFieldStyle
) {

    var counterText by remember(key1 = value) {
        mutableStateOf("${value.length}/${maxLenght}")
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            BaseText(
                text = label,
                fontSize = 14.sp,
                color = Color.Black
            )
            if (counterText != null){
                BaseText(
                    text = counterText,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
        BaseOutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                if (placeholder.isNotBlank()){
                    BaseText(
                        text = placeholder,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            },
            shape = RoundedCornerShape(12.dp),
            textStyle = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = Color.Black,
                fontFamily = poppinsFontFamily
            ),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
            maxLines = maxLines,
            isError = isError
        )
    }

}

@ExperimentalMaterial3Api
@Preview
@Composable
fun HightTextFieldWithLabelPreview() {
    GlengarryTheme {
        Surface {
            HightTextFieldWithLabel(
                label = "email",
                placeholder = "search...",
                maxLenght = 1000
            )
        }
    }
}