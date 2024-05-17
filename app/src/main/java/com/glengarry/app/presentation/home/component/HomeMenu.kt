package com.glengarry.app.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.glengarry.app.R
import com.glengarry.app.presentation.home.domain.MenuItem
import com.glengarry.app.ui.theme.GlengarryTheme

@Composable
fun HomeMenu(
    modifier: Modifier = Modifier,
    menuItems: List<MenuItem> = emptyList(),
    onClick: (MenuItem) -> Unit = {}
) {
    Row (
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        repeat(menuItems.size){iteration ->
            MenuItem(
                menu = menuItems[iteration],
                onClick = onClick
            )
        }
    }

}

@Preview
@Composable
fun HomeMenuPreview() {
    GlengarryTheme {
        Surface {
            val menuItems = listOf(
                MenuItem(
                    icon = R.drawable.logo_fashion,
                    label = R.string.label_fashion
                ),
                MenuItem(
                    icon = R.drawable.logo_electronic,
                    label = R.string.label_electronic
                ),
                MenuItem(
                    icon = R.drawable.logo_book,
                    label = R.string.label_book
                ),
                MenuItem(
                    icon = R.drawable.logo_sport,
                    label = R.string.label_sport
                )

            )
            HomeMenu(
                menuItems = menuItems,
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}