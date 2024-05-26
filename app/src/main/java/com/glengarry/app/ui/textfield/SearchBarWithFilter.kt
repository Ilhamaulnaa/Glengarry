package com.glengarry.app.ui.textfield

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.glengarry.app.R
import com.glengarry.app.ui.component.Filter
import com.glengarry.app.ui.text.TypewriterText
import com.glengarry.app.ui.theme.GlengarryTheme

@ExperimentalMaterial3Api
@Composable
fun SearchBarWithFilter(
    modifier: Modifier = Modifier,
    value: String,
    texts: List<String> = emptyList(),
    placeholder: String = "",
    onValueChanged: (String) -> Unit = {},
    onFilterClick: () -> Unit = {},
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        SmallSearchBar(
            modifier = Modifier.weight(1f),
            value = value,
            onValueChange = onValueChanged,
            placeholder = placeholder
        )
//        TypewriterText(texts = texts)
        Spacer(modifier = Modifier.width(10.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .clickable { onFilterClick() }
                .size(40.dp),
            contentAlignment = Alignment.Center
        ) {
            Filter(text = "Category")
        }
    }

//    Row (
//        modifier = modifier
//            .clip(RoundedCornerShape(10.dp))
//            .fillMaxWidth()
//            .clickable { onValueChanged }
//            .background(Color(0x66FFFFFF))
//            .height(52.dp)
//            .padding(horizontal = 12.dp, vertical = 6.dp),
//        verticalAlignment = Alignment.CenterVertically,
//    ){
//        Icon(
//            painter = painterResource(id = R.drawable.ic_search),
//            contentDescription = "Search",
//            tint = Color.White
//        )
//        Spacer(modifier = Modifier.width(12.dp))
//        TypewriterText(texts = texts)
//        Spacer(modifier = Modifier.width(4.dp))
//        Box (
//            modifier = Modifier
//                .clip(RoundedCornerShape(10.dp))
//                .size(40.dp)
//                .background(Color(0xFFE6E6E6))
//                .clickable { onFilterClick() },
//            contentAlignment = Alignment.Center
//        ){
//            Filter(text = "Category")
//        }
//    }

}

@ExperimentalMaterial3Api
@Preview
@Composable
fun SearchBarWithFilterPreview() {
    GlengarryTheme {
        val texts = listOf(
            "Search Fashion! \uD83D\uDC9C",
            "Search All Your Needs...\uD83E\uDD73"
        )
        Surface(
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            SearchBarWithFilter(
                modifier = Modifier.padding(16.dp),
                value = "Search",
                texts = texts,
                placeholder = "Search"
            )
        }
    }
}