package com.glengarry.app.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.glengarry.app.R
import com.glengarry.app.presentation.home.domain.Profile
import com.glengarry.app.ui.theme.GlengarryTheme

@Composable
fun HomeHeader(
    modifier: Modifier = Modifier,
    onSearchBarClick: () -> Unit = {},
    texts: List<String> = emptyList(),
    user: String
) {

    var profile by remember {
        mutableStateOf(Profile())
    }

    Box(
        modifier = Modifier
            .height(150.dp)
            .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
    ) {

        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.banner_home),
            contentDescription = "baner"
        )
        Column(
            modifier = Modifier
                .matchParentSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            ProfileHome(
                profile = profile,
                user = "Hi, $user"
            )
            Spacer(modifier = Modifier.height(26.dp))
            HomeSearchBar(
                onClick = onSearchBarClick,
                texts = texts,
                modifier = Modifier.fillMaxWidth()
            )
        }
        
    }

}

@Preview
@Composable
fun HomeHeaderPreview() {
    GlengarryTheme {
        Surface {
            HomeHeader(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                user = "Ilham Maulana"
            )
        }
    }
}