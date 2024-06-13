package com.glengarry.app.ui.textfield

import android.health.connect.datatypes.units.Length
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.theme.darkBlue
import com.glengarry.app.ui.theme.grey
import com.glengarry.app.ui.theme.poppinsFontFamily


enum class SmalltextFieldWithLabelType{
    FILLED, OUTLINED
}
@ExperimentalMaterial3Api
private val SmallTextFieldWithLabelFilledColors @Composable get() = TextFieldDefaults.outlinedTextFieldColors(
    disabledBorderColor = Color.Transparent,
    unfocusedBorderColor = Color.Transparent,
    focusedBorderColor = darkBlue,
    containerColor = darkBlue
)

@ExperimentalMaterial3Api
private val SmallTextFieldWithLabelOutlinedColors @Composable get() = TextFieldDefaults.outlinedTextFieldColors(
    unfocusedBorderColor = grey,
    containerColor = Color.Transparent,
    focusedBorderColor = darkBlue
)
@ExperimentalMaterial3Api
@Composable
fun SmallTextFieldWithLabel(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChanged: (String) -> Unit,
    maxLength: Int? = null,
    placeholder: String = "",
    singleLine: Boolean = true,
    minlines: Int = 1,
    maxLines: Int = minlines,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    enabled: Boolean = true,
    isError: Boolean = false,
    supportingText: String = "",
    prefixText: String = "",
    type: SmalltextFieldWithLabelType = SmalltextFieldWithLabelType.OUTLINED
) {

    val colors = when(type) {
        SmalltextFieldWithLabelType.FILLED -> SmallTextFieldWithLabelFilledColors
        SmalltextFieldWithLabelType.OUTLINED -> SmallTextFieldWithLabelOutlinedColors
    }

    val counterText by remember(key1 = value) {
        mutableStateOf("${value.length}/${maxLength}")
    }

    val leadingIcon: @Composable (() -> Unit)? = if ( prefixText.isNotEmpty()) {
        {
            Row {
                Spacer(modifier = Modifier.width(16.dp))
                BaseText(
                    text = prefixText,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp
                )
            }
        }
    } else null

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            BaseText(
                text = label,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp
            )
            if (maxLength != null){
                BaseText(
                    text = counterText,
                    fontSize = 10.sp,
                    color = Color(0xFF787878)
                )
            }
        }
        BaseOutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChanged,
            colors = colors,
            shape = RoundedCornerShape(12.dp),
            singleLine = singleLine,
            minLines = minlines,
            maxLines = maxLines,
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
            enabled = enabled,
            textStyle = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                fontSize = 14.sp,
                fontFamily = poppinsFontFamily
            ),
            placeholder = {
                if (placeholder.isNotBlank()){
                    BaseText(
                        text = placeholder,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray,
                        fontSize = 14.sp,
                    )
                }
            },
            leadingIcon = leadingIcon,
            keyboardOptions = keyboardOptions,
            isError = isError
        )
        AnimatedVisibility(visible = supportingText.isNotEmpty() ) {
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
fun SmallTextFieldWithLabelPreview() {
    GlengarryTheme {
        Surface {
            var text by remember {
                mutableStateOf("")
            }
            SmallTextFieldWithLabel(
                label = "email",
                value = text,
                onValueChanged = { text = it},
                placeholder = "search",
                prefixText = "test",
                type = SmalltextFieldWithLabelType.OUTLINED,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            )
        }
    }
}
