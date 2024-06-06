package com.glengarry.app.ui.buttomsheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme

@ExperimentalMaterial3Api
@ExperimentalLayoutApi
@Composable
fun MultipleChipFilter(
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = {},
    options: List<String> = emptyList(),
    selectedOption: List<String> = emptyList(),
    enabled: Boolean = true,
    type: ChipFilterType = ChipFilterType.FASHION
) {

    val colors = when(type){
        ChipFilterType.FASHION -> fashionChipColors
        ChipFilterType.ELECTRONIC -> electronicChipColors
        ChipFilterType.BOOK -> bookChipColors
        ChipFilterType.SPORT -> sportChipColors
    }
    val border = when(type){
        ChipFilterType.FASHION -> fashionChipBorder
        ChipFilterType.ELECTRONIC -> electronicChipBorder
        ChipFilterType.BOOK -> bookChipBorder
        ChipFilterType.SPORT -> sportChipBorder
    }

    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        options.forEach { option ->
            FilterChip(
                selected = selectedOption.contains(option),
                onClick = { onClick(option) },
                label = {
                    BaseText(
                        text = option,
                        fontWeight = FontWeight.Medium,
                        fontSize = 11.sp
                    )
                },
                colors = colors,
                border = border,
                shape = RoundedCornerShape(12.dp),
                enabled = enabled
            )
        }

    }

}

@ExperimentalLayoutApi
@ExperimentalMaterial3Api
@Preview
@Composable
fun MultipleChipFilterPreview() {
    GlengarryTheme {
        Surface {

            val option = listOf("Fashion","Electronic", "Book", "SPort")
            MultipleChipFilter(
                onClick = {},
                options = option,
                enabled = true,
                modifier = Modifier.padding(15.dp)
            )
        }
    }
}