package com.glengarry.app.ui.dropdown

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme

@Composable
fun DropdownTextFieldWithLabel(
    modifier: Modifier = Modifier,
    placeholder: String = "",
    label: String,
    selectedOption: String,
    options: List<String>,
    onSelected: (Int) -> Unit,
    isError: Boolean = false,
    supportingText: String = ""
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
    ) {
        BaseText(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF404040)
        )
        DropDownTextField(
            placeholder = placeholder,
            selectedOption = selectedOption,
            options = options,
            onSelected = onSelected,
            isError = isError
        )
        AnimatedVisibility(visible = true) {
            BaseText(
                text = supportingText,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.error
            )
        }
    }

}

@Preview
@Composable
fun DropdownTextFieldWithLabelPreview() {
    GlengarryTheme {
        Surface {
            val options = listOf("Male", "Female")
            var selectedOption by remember {
                mutableStateOf(options[0])
            }
            DropdownTextFieldWithLabel(
                label = "Gender",
                onSelected = { selectedOption = options[it]},
                options = options,
                selectedOption = selectedOption,
            )
        }
    }
}