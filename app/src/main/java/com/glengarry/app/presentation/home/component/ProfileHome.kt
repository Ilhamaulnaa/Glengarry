package com.glengarry.app.presentation.home.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.ui.theme.GlengarryTheme
import coil.compose.AsyncImage
import com.glengarry.app.R
import com.glengarry.app.presentation.home.domain.Profile
import com.glengarry.app.ui.text.BaseText

@Composable
fun ProfileHome(
    modifier: Modifier = Modifier,
    profile: Profile,
    user: String
) {

    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        AsyncImage(
            model = profile.photo,
            contentDescription = profile.photo,
            placeholder = painterResource(id = R.drawable.img_profile),
            error = painterResource(id = R.drawable.img_profile),
            modifier = Modifier
                .clip(CircleShape)
                .size(50.dp)
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = CircleShape,
                )
        )
        Spacer(modifier = Modifier.width(12.dp))
        BaseText(
            text = user,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = Color.White
        )
    }

}

@Preview
@Composable
fun ProfileHomePreview() {
    GlengarryTheme {
        Surface {
            val profile = Profile(
                photo = "https://i.pinimg.com/474x/98/51/1e/98511ee98a1930b8938e42caf0904d2d.jpg",
                name = "Ilham Maulana"
            )
            ProfileHome(
                profile = profile,
                user = "Ilham Maulana",
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}