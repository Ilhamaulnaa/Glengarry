package com.glengarry.app.ui.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme

@Composable
fun TertiaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {}
) {

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .clickable { onClick() }
            .shadow(
                elevation = 1.dp,
                ambientColor = Color(0xFF080020),
                spotColor = Color(0xFF080020)
            )
            .background(Color(0xFFF5F2F8))
            .padding(horizontal = 16.dp, vertical = 6.dp),
        contentAlignment = Alignment.Center
    ){
        BaseText(
            text = text,
            fontWeight = FontWeight.Medium,
            lineHeight = 30.sp,
            fontSize = 15.sp,
            color = Color(0xFF080020)
        )
    }

}

@Preview
@Composable
fun TertiaryButtonPreview() {
    GlengarryTheme {
        Surface {
            TertiaryButton(
                text = "See All",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}