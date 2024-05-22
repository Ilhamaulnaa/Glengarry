package com.glengarry.app.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.R
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme

@Composable
fun Filter(
    modifier: Modifier = Modifier,
    text: String = "",
    onClick: () -> Unit = {}
) {

    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_filter),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .clickable { onClick() }
        )
        BaseText(
            text = text,
            fontSize = 6.sp,
            color = Color(0xFF000000)
        )
    }

}

@Preview
@Composable
fun FilterPreview() {
    GlengarryTheme {
        Surface {
            Filter(
                modifier = Modifier.padding(16.dp),
                text = "Category"
            )
        }
    }
}