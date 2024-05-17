package com.glengarry.app.presentation.home.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.R
import com.glengarry.app.presentation.home.domain.CarouselItem
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme

@ExperimentalFoundationApi
@Composable
fun HomeCarouselItem(
    modifier: Modifier = Modifier,
    carouselItem: CarouselItem,
    onClick: (CarouselItem) -> Unit = {}
) {

    Box (
        modifier = modifier
            .clickable { onClick(carouselItem) },
        contentAlignment = Alignment.Center
    ){

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .size(200.dp),
            painter = painterResource(id = R.drawable.banner_carousel),
            contentDescription = null,
        )
        BaseText(
            modifier = Modifier.align(Alignment.Center),
            text = carouselItem.title,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )

    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun HomeCarouselItemPreview() {
    GlengarryTheme {
        Surface {
            val carouselItem = CarouselItem(
                id = 0,
                title = "WEAR THE REAL\nFASHION"
            )
            HomeCarouselItem(
                carouselItem = carouselItem
            )
        }
    }
}