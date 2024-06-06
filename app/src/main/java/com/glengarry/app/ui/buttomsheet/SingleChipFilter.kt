package com.glengarry.app.ui.buttomsheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material.Colors
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.theme.grey
import com.glengarry.app.ui.theme.poppinsFontFamily
import org.koin.androidx.compose.get

enum class ChipFilterType {
    FASHION, ELECTRONIC, BOOK, SPORT
}

@ExperimentalMaterial3Api
val fashionChipColors @Composable get() =
    FilterChipDefaults.filterChipColors(
        containerColor = Color.White,
        selectedContainerColor = Color(0xFFE55D51),
        selectedLabelColor = Color(0xFFFFFFFF)
    )
@ExperimentalMaterial3Api
val fashionChipBorder @Composable get() =
    FilterChipDefaults.filterChipBorder(
        borderColor = Color(0xFF787878),
        selectedBorderColor = Color(0xFFE55D51)
    )

@ExperimentalMaterial3Api
val electronicChipColors @Composable get() =
    FilterChipDefaults.filterChipColors(
        containerColor = Color(0xFF787878),
        selectedContainerColor = Color(0xFF38AF89),
        selectedLabelColor = Color(0xFFFFFFFF)
    )
@ExperimentalMaterial3Api
val electronicChipBorder @Composable get() =
    FilterChipDefaults.filterChipBorder(
        borderColor = Color(0xFF787878),
        selectedBorderColor = Color(0xFF38AF89)
    )

@ExperimentalMaterial3Api
val bookChipColors @Composable get() =
    FilterChipDefaults.filterChipColors(
        containerColor = Color(0xFF787878),
        selectedContainerColor = Color(0xFF4F85CB),
        selectedLabelColor = Color(0xFFFFFFFF)
    )
@ExperimentalMaterial3Api
val bookChipBorder @Composable get() =
    FilterChipDefaults.filterChipBorder(
        borderColor = Color(0xFF787878),
        selectedBorderColor = Color(0xFF4F85CB)
    )

@ExperimentalMaterial3Api
val sportChipColors @Composable get() =
    FilterChipDefaults.filterChipColors(
        containerColor = Color(0xFF787878),
        selectedContainerColor = Color(0xFFffff00 ),
        selectedLabelColor = Color(0xFFFFFFFF)
    )
@ExperimentalMaterial3Api
val sportChipBorder @Composable get() =
    FilterChipDefaults.filterChipBorder(
        borderColor = Color(0xFF787878),
        selectedBorderColor = Color(0xFFffff00 )
    )


@ExperimentalMaterial3Api
@ExperimentalLayoutApi
@Composable
fun SingleChipFilter(
    modifier: Modifier = Modifier,
    options: List<String> = emptyList(),
    onClick: (String) -> Unit,
    selectedOption: String,
    enable: Boolean = true,
    type: ChipFilterType = ChipFilterType.FASHION
) {

    val colors = when (type){
        ChipFilterType.FASHION -> fashionChipColors
        ChipFilterType.ELECTRONIC -> electronicChipColors
        ChipFilterType.BOOK -> bookChipColors
        ChipFilterType.SPORT -> sportChipColors
    }
    val border = when (type){
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
                selected = selectedOption == option,
                onClick = { onClick(String()) },
                label = {
                    Text(
                        text = option,
                        fontSize = 12.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Medium
                    )
                },
                colors = colors,
                border = border
            )
        }

    }

}

@ExperimentalLayoutApi
@ExperimentalMaterial3Api
@Preview
@Composable
fun SingleChippFilterPreview() {
    GlengarryTheme {
        Surface {

            val options = listOf("Fashion", "Electronic", "Book", "Sport")
            var selectedOptions by remember {
                mutableStateOf(options[0])
            }
            val type = remember(key1 = selectedOptions) {
                when (selectedOptions) {
                    "Fashion" -> ChipFilterType.FASHION
                    "ELectronic" -> ChipFilterType.ELECTRONIC
                    "Book" -> ChipFilterType.BOOK
                    else -> ChipFilterType.SPORT
                }
            }
            SingleChipFilter(
                onClick = { selectedOptions = it },
                options = options,
                selectedOption = selectedOptions ,
                enable = true,
                type = type
            )
        }
    }
}