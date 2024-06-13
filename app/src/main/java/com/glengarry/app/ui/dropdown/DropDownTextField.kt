package com.glengarry.app.ui.dropdown

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.theme.darkBlue
import com.glengarry.app.ui.theme.grey

@Composable
fun DropDownTextField(
    modifier: Modifier = Modifier,
    placeholder: String = "",
    selectedOption: String,
    options: List<String>,
    onSelected: (Int) -> Unit,
    isError: Boolean = false
) {

    var expanded by remember {
        mutableStateOf(false)
    }
    val borderWidth = remember(key1 = expanded) {
        if (expanded) 2.dp else 1.dp
    }
    val borderColor = remember(key1 = expanded) {
        if (expanded) darkBlue else Color(0xFFA4A4A4)
    }
    val borderColorWithError = if (isError) androidx.compose.material3.MaterialTheme.colorScheme.error else borderColor

    val text by remember(key1 = selectedOption) {
        mutableStateOf(selectedOption.ifEmpty { placeholder })
    }
    val textColor by remember(key1 = selectedOption) {
        mutableStateOf(if (selectedOption.isEmpty()) grey else Color.Unspecified)
    }


    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .height(40.dp)
            .border(
                width = borderWidth,
                color = borderColorWithError,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { expanded = true }
    ){
        Row (
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            BaseText(
                text = text,
                color = textColor,
                fontSize = 14.sp,
                modifier = Modifier.weight(1f)
            )
            Icon(imageVector = Icons.Filled.KeyboardArrowDown , contentDescription = null)
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEachIndexed { index, item ->
                DropdownMenuItem(
                    onClick = {
                        expanded = true
                        onSelected(index)
                    },
                    text = {
                        BaseText(text = item, fontSize = 14.sp)
                    }
                )
            }
        }

    }

}

@Preview
@Composable
fun DropDownTextFeildPreview() {
    GlengarryTheme {
        Surface {
            val genders = listOf("Male", "Female")
            var selectedGender by remember { mutableStateOf("") }
            DropDownTextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                isError = true,
                selectedOption = selectedGender,
                options = genders,
                onSelected = { selectedGender = genders[it] }
            )
        }
    }
}