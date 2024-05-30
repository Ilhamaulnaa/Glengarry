package com.glengarry.app.presentation.profile.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.R
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.theme.grey
import com.glengarry.app.ui.theme.poppinsFontFamily

@ExperimentalMaterial3Api
@Composable
fun CustomButtonProfile(
    modifier: Modifier = Modifier,
    text: String = "",
    img: Int,
    onCLick: () -> Unit = {}
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 0.5.dp,
                color = grey,
                shape = RoundedCornerShape(12.dp)
            )
            .height(39.dp)
            .background(Color(0xFFF5F2F8), shape = RoundedCornerShape(12.dp))
            .clickable { onCLick() }
            .clip(RoundedCornerShape(12.dp)),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically

    ){
        Image(
            painter = painterResource(id = img),
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .size(20.dp)
        )
        Spacer(modifier = Modifier.width(15.dp))
        BaseText(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp),
            text = text,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = Color(0xFF000000)
        )
        Icon(
            imageVector = Icons.Filled.ArrowForwardIos ,
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun TextFieldProfilePreview() {
    GlengarryTheme {
        Surface {
            CustomButtonProfile(
                text = "Privacy",
                img = R.drawable.ic_privacy,
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}