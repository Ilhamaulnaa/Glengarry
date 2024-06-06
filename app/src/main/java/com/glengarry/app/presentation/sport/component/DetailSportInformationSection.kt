package com.glengarry.app.presentation.sport.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glengarry.app.presentation.sport.domain.SportDetail
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.theme.grey

@Composable
fun DetailSportInformationSection(
    modifier: Modifier = Modifier,
    details: SportDetail
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        BaseText(
            text = "Detail produk",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        BaseText(
            text = details.detailProduct,
            fontWeight = FontWeight(400),
            fontSize = 16.sp,
            color = Color(0xFF404040)
        )
        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 0.5.dp,
            color = grey
        )
        Spacer(modifier = Modifier.height(5.dp))
        BaseText(
            text = "Deskripsi produk",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
//        repeat(details.description.size){ iteration ->
//            TextWithNumber(number = iteration + 1, text = details.description[iteration])
//        }
        BaseText(
            text = details.description,
            fontWeight = FontWeight(400),
            fontSize = 16.sp,
            color = Color(0xFF404040)
        )
    }

}

@Preview
@Composable
fun DetailSportInformationSectionPreview() {
    GlengarryTheme {
        Surface {
            val detail = SportDetail(
                detailProduct = "Etalase",
                description = "Harap pastikan pesanan sudah sesuai sebelum di checkout, produk dengan kualitas yg mampu bersaing dengan brand terkenal"
            )
            DetailSportInformationSection(
                details = detail
            )
        }
    }
}