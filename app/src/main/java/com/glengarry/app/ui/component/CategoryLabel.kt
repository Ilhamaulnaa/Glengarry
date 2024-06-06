package com.glengarry.app.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.presentation.fashion.domain.FashionDetail
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.theme.darkBlue

@ExperimentalLayoutApi
@Composable
fun CategoryLabel(
    modifier: Modifier = Modifier,
    detail: FashionDetail
) {

    Box (
        modifier = modifier
            .fillMaxWidth()
            .background(darkBlue)
            .padding(horizontal = 16.dp, vertical = 10.dp),
        contentAlignment = Alignment.TopStart
    ){

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            maxItemsInEachRow = 4
        ) {
            detail.label.forEach { label ->
                BaseText(
                    text = label,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
        }

    }

}

@ExperimentalLayoutApi
@Preview
@Composable
fun CategoryLabelPreview() {
    GlengarryTheme {
        Surface {
            val detail = FashionDetail(
                label = listOf("Fashion","Electronic","Book","Sport")
            )
            CategoryLabel(
                modifier = Modifier.padding(20.dp),
                detail = detail
            )
        }
    }
}