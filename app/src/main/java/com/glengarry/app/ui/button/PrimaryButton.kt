package com.glengarry.app.ui.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.theme.darkBlue
import com.glengarry.app.ui.theme.poppinsFontFamily

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
    fontSize: TextUnit = 16.sp,
    enabled: Boolean = true,
    loading: Boolean = false
) {

    val buttonText = if (loading) "loading.." else text
    val buttonEnabled = if (loading) false else enabled

    androidx.compose.material3.Button(
        onClick = onClick,
        modifier = modifier.height(50.dp),
        enabled = buttonEnabled,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = darkBlue,
            contentColor = Color.White
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 5.dp, 5.dp, 5.dp
        ),
        contentPadding = PaddingValues(
            vertical = 14.dp,
            horizontal = 28.dp
        ),
    ) {
        Text(
            text = buttonText,
            fontSize = fontSize,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }
    
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    GlengarryTheme {
        Surface {
            PrimaryButton(
                text = "Masuk",
                onClick = {},
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}