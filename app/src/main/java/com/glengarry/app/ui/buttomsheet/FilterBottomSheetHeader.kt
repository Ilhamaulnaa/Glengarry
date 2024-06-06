package com.glengarry.app.ui.buttomsheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.glengarry.app.ui.button.BaseClickableText
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.theme.poppinsFontFamily

@Composable
fun FilterBottomSheetHeader(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {

    Row (
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){

        BaseText(
            text = "Filter",
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = Color.Black
        )
        BaseClickableText(
            modifier = Modifier,
            text = "Reset All",
            onClick = { onClick() },
            style = TextStyle(
                fontFamily = poppinsFontFamily,
                fontSize = 12.sp,
                color = Color(0xFF080020)
            )
        )

    }

}

@Preview
@Composable
fun FilterBottomSheetHeaderPreview() {
    GlengarryTheme {
        Surface {
            FilterBottomSheetHeader()
        }
    }
}