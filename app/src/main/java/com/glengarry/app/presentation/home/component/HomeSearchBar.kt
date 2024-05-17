package com.glengarry.app.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.glengarry.app.R
import com.glengarry.app.ui.text.TypewriterText
import com.glengarry.app.ui.theme.GlengarryTheme

@Composable
fun HomeSearchBar(
    modifier: Modifier = Modifier,
    texts: List<String> = emptyList(),
    onClick: () -> Unit = {}
) {

    Row (
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .clickable { onClick }
            .background(Color(0x66FFFFFF))
            .padding(horizontal = 12.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White
        )
        TypewriterText(texts = texts)

    }

}

@Preview
@Composable
fun HomeSearchBarPreview() {
    GlengarryTheme {
        Surface(
            color = androidx.compose.material3.MaterialTheme.colorScheme.primaryContainer
        ) {
            HomeSearchBar(
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}