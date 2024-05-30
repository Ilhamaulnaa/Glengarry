package com.glengarry.app.ui.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.Text
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
fun SmallPrimaryButtonWhite(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
    enable: Boolean = true,
    loading: Boolean = false,
    isRounded: Boolean = false
) {
    val buttonText = if (loading) "Loading..." else text
    val buttonEnabled = if (loading) false else enable
    val borderShape = if (isRounded) CircleShape else RoundedCornerShape(12.dp)
    Box(
        modifier = modifier
            .shadow(
                elevation = 8.dp,
                spotColor = Color.White,
                ambientColor = Color(0xFF080020)
            )
            .clip(borderShape)
            .height(39.dp)
            .clickable(enabled = buttonEnabled) { onClick() }
            .background(color = Color(0xFFFFFF))
            .border(
                width = 1.dp,
                color = Color(0xFF080020),
                shape = borderShape

            )
            .padding(horizontal = 8.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        BaseText(
            text = buttonText,
            fontSize = 12.5.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF080020),
        )
    }
}

@Preview
@Composable
fun SmallPrimaryButtonWhitePreview() {
    GlengarryTheme {
        Surface {
            SmallPrimaryButtonWhite(
                text = "Cancel",
                onClick = {},
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}