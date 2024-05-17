package com.glengarry.app.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
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
import com.glengarry.app.R
import com.glengarry.app.presentation.home.domain.MenuItem
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme

@Composable
fun MenuItem(
    modifier: Modifier = Modifier,
    menu: MenuItem,
    onClick: (MenuItem) -> Unit = {}
) {

    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box (
            modifier = modifier
                .clickable { onClick(menu) }
                .clip(CircleShape)
                .background(Color(0xFFF5F2F8)),
            contentAlignment = Alignment.Center
        ){
            Image(
                modifier = Modifier.size(33.dp),
                painter = painterResource(id = menu.icon) ,
                contentDescription = stringResource(id = menu.label),
            )
        }
        BaseText(
            text = stringResource(id = menu.label),
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium
        )
    }

}

@Preview
@Composable
fun MenuItemPreview() {
    GlengarryTheme {
        Surface {
            val menu = MenuItem(
                icon = R.drawable.logo_fashion,
                label = R.string.label_fashion
            )
            MenuItem(
                menu = menu
            )
        }
    }
}