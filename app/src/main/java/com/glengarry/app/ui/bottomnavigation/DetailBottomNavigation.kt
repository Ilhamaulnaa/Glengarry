package com.glengarry.app.ui.bottomnavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.glengarry.app.ui.button.SmallPrimaryButton
import com.glengarry.app.ui.button.SmallPrimaryButtonWhite
import com.glengarry.app.ui.theme.GlengarryTheme

@Composable
fun DetailBottomNavigation(
    modifier: Modifier = Modifier,
    onBuyClick: () -> Unit = {},
    onCartClick: () -> Unit = {}
) {


    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SmallPrimaryButtonWhite(
            text = "Buy Now",
            onClick = onBuyClick,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        SmallPrimaryButton(
            text = "+ Cart",
            onClick = onCartClick,
            modifier = Modifier.weight(1f)
        )
    }

}

@Preview
@Composable
fun DetailBottomNavigationPreview() {
    GlengarryTheme {
        Surface {
            DetailBottomNavigation()
        }
    }
}