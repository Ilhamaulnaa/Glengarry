package com.glengarry.app.ui.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
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
import com.glengarry.app.ui.theme.grey

@Composable
fun SmallPrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    loading: Boolean = false,
    isRounded: Boolean = false
) {

    val buttonText = if (loading)"Loading..." else text
    val buttonEnabled = if (loading) false else enabled
    val buttonBackground = if (loading) grey else Color(0xFF080020)
    val borderShape = if (isRounded) CircleShape else RoundedCornerShape(12.dp)

    Box(
        modifier = modifier
            .shadow(
                elevation = 8.dp,
                spotColor = Color(0xFF9365CD),
                ambientColor = Color(0xFF9365CD)
            )
            .clip(borderShape)
            .clickable(enabled = buttonEnabled) { onClick() }
            .height(39.dp)
            .background(buttonBackground)
            .padding(horizontal = 8.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center
    ){
        BaseText(
            text = buttonText,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            color = Color.White
        )
    }

}

@Preview
@Composable
fun SmallPrimaryButtonPreview() {
    GlengarryTheme {
        Surface {
            SmallPrimaryButton(
                text = "Mantap",
                onClick = {},
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}