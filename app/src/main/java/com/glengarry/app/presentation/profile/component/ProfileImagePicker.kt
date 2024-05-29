package com.glengarry.app.presentation.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.glengarry.app.R
import com.glengarry.app.presentation.profile.domain.Profile
import com.glengarry.app.ui.theme.GlengarryTheme

@Composable
fun ProfileImagePicker(
    modifier: Modifier = Modifier,
    img: Any,
    onEditProfileClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
    ) {
        AsyncImage(
            model = img,
            contentDescription = "profile",
            placeholder = painterResource(id = R.drawable.ic_profile),
            error = painterResource(id = R.drawable.ic_profile),
            modifier = Modifier
                .size(60.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFF000000),
                    shape = CircleShape
                ),
        )
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(20.dp)
                .align(Alignment.BottomEnd)
                .background(Color.White)
                .clickable { onEditProfileClick }
        ){
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .padding(3.dp)
            )
        }
    }
}

@Preview
@Composable
fun ProfileImagePickerPreview() {
    GlengarryTheme {
        Surface {
            ProfileImagePicker(
                img = "",
                onEditProfileClick = {},
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}