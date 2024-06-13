package com.glengarry.app.presentation.addbusiness.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
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
import coil.compose.AsyncImage
import com.glengarry.app.R
import com.glengarry.app.ui.theme.GlengarryTheme

@Composable
fun BusinessImagePicker(
    modifier: Modifier = Modifier,
    img: Any,
    onEditAddBusinessClick: () -> Unit = {}
) {

    Box( modifier = modifier.wrapContentSize() ){
        AsyncImage(
            model = img,
            contentDescription = null,
            placeholder = painterResource(id = R.drawable.img_add_business),
            error = painterResource(id = R.drawable.img_add_business),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .size(60.dp)
        )
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .padding(3.dp)
                .size(12.dp)
                .clip(CircleShape)
                .background(Color.White)
                .padding(2.dp)
                .align(Alignment.BottomEnd)
                .clip(CircleShape)
                .clickable { onEditAddBusinessClick() }
                .size(12.dp)
                .clip(CircleShape),
            contentAlignment = Alignment.Center
        ){
            Icon(
                painter = painterResource(id = R.drawable.ic_edit),
                contentDescription = "edit",
            )
        }
    }

}

@Preview
@Composable
fun BusinessImagePickerPreview() {
    GlengarryTheme {
        Surface {
            BusinessImagePicker(
                img = "",
                onEditAddBusinessClick = {}
            )
        }
    }
}