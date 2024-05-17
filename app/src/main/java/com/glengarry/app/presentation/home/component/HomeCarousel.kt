package com.glengarry.app.presentation.home.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.glengarry.app.presentation.home.domain.CarouselItem
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.theme.darkBlue

@ExperimentalFoundationApi
@Composable
fun HomeCarousel(
    modifier: Modifier = Modifier,
    carouselItem: List<CarouselItem> = emptyList(),
    onClick: (CarouselItem) -> Unit = {}
) {

    val pagerState = rememberPagerState(pageCount = { carouselItem.size })

    Column {
        HorizontalPager(state = pagerState) { index ->
            HomeCarouselItem(
                carouselItem = carouselItem[index],
                onClick = onClick,
                modifier = modifier
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount){ iteration ->
                val color by animateColorAsState(
                    targetValue = if (pagerState.currentPage == iteration) darkBlue else Color(0xFFEBE5F2),
                    label = "indicator color"
                )
                Box( modifier = Modifier
                    .size(10.dp)
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                )
            }
        }
    }
    
}

@ExperimentalFoundationApi
@Preview
@Composable
fun HomeCarouselPreview() {
    GlengarryTheme {
        val carouselItems =(1..3).map {
            CarouselItem(
                id = it,
                title = "WEAR THE REAL\n" +
                        "FASHION"
            )
        }
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column {
                Spacer(modifier = Modifier.height(16.dp))
                HomeCarousel(
                    carouselItem = carouselItems,
                    )
            }
        }
    }
}