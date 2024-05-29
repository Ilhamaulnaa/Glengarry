package com.glengarry.app.presentation.profile.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.glengarry.app.R
import com.glengarry.app.presentation.profile.domain.Profile
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme

@Composable
fun ProfileHeader(
    modifier: Modifier = Modifier,
    profile: Profile,

) {

    var img: Any by remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ProfileImagePicker(
            img = img,
            onEditProfileClick = {}
        )
        Spacer(modifier = Modifier.height(16.dp))
        BaseText(
            text = profile.name,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        )
        BaseText(
            text = profile.email,
            fontSize = 12.sp,
            color = Color(0xFF5E596E)
        )

    }

}

@Preview
@Composable
fun ProfileHeaderPreview() {
    GlengarryTheme {
        Surface {
            val profile = Profile(
                photo = "",
                "Ilham Maulana",
                "ilhmlna@gmail.com"
            )
            ProfileHeader(
                profile = profile
            )
        }
    }
}