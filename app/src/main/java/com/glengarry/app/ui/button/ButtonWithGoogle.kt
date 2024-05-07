package com.glengarry.app.ui.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.R
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme

@Composable
fun ButtonWithGoogle(
    modifier: Modifier = Modifier,
    onCLick: () -> Unit = {},
) {

    Row(
        modifier = modifier
            .border(
                width = 0.5.dp,
                color = Color(0xFFA4A4A4),
                shape = RoundedCornerShape(12.dp)
            )
            .height(51.dp)
            .clickable { onCLick() }
            .clip(RoundedCornerShape(12.dp)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo_google_icon),
            contentDescription = "google button",
            contentScale = ContentScale.FillBounds ,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .size(20.dp)
        )
        BaseText(
            text = "Sign up with Google",
            fontSize = 14.sp,
            color = Color(0xFF4D4D4D),
            modifier = Modifier
                .padding(horizontal = 20.dp)
        )

    }

}

@Preview
@Composable
fun ButtonWithGooglePreview() {
    GlengarryTheme {
        Surface {
            ButtonWithGoogle()
        }
    }
}