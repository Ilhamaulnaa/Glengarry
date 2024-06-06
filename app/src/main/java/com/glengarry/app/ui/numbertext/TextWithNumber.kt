package com.glengarry.app.ui.numbertext

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme

@Composable
fun TextWithNumber(
    modifier: Modifier = Modifier,
    number: Int,
    text: String
) {

    Row (
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ){

        Box (
            modifier = Modifier
                .clip(CircleShape)
                .size(16.dp)
                .background(
                    brush = Brush.linearGradient(
                        0f to Color(0xff5d5fef),
                        1f to Color(0xffb5b6ff),
                        start = Offset(3f, 15.6f),
                        end = Offset(15f, 1.8f)
                    )
                ),
            contentAlignment = Alignment.Center
        ){
            BaseText(
                text = number.toString(),
                fontWeight = FontWeight.Medium,
                fontSize = 10.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        BaseText(
            text = text,
            fontSize = 12.sp,
        )

    }

}

@Preview
@Composable
fun TextWithNumberPreview() {
    GlengarryTheme {
        Surface {
            TextWithNumber(
                number = 1,
                text = "Lorem Ipsum",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}