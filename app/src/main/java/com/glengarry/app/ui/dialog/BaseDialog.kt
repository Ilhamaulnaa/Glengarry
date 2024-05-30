package com.glengarry.app.ui.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.glengarry.app.ui.button.SmallPrimaryButton
import com.glengarry.app.ui.button.SmallPrimaryButtonWhite
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme

data class BaseDialogButton(
    val title: String = "",
    val onClick: () -> Unit = {}
)
@Composable
fun BaseDialog(
    modifier: Modifier = Modifier,
    message: String,
    positiveButton: BaseDialogButton,
    negativeButton: BaseDialogButton? = null,
) {

    Dialog(onDismissRequest = {}) {
        androidx.compose.material3.Card(
            modifier = modifier,
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colors.background)
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BaseText(
                    text = message,
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(26.dp))
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    if (negativeButton != null){
                        SmallPrimaryButtonWhite(
                            text = negativeButton.title,
                            onClick = negativeButton.onClick,
                            isRounded = true,
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(40.dp))
                    }
                    SmallPrimaryButton(
                        text = positiveButton.title,
                        onClick = positiveButton.onClick,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }

}

@Preview
@Composable
fun BaseDialogPreview() {
    GlengarryTheme {
        Surface {
            BaseDialog(
                modifier = Modifier.padding(20.dp),
                message = "Do you want to logout ?",
                positiveButton = BaseDialogButton("Yes"),
                negativeButton = BaseDialogButton("Cancel")
            )
        }
    }
}