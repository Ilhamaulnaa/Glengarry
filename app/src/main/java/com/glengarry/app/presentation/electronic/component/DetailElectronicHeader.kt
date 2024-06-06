package com.glengarry.app.presentation.electronic.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.common.toRupiah
import com.glengarry.app.R
import com.glengarry.app.presentation.electronic.domain.ElectronicDetail
import com.glengarry.app.presentation.fashion.domain.FashionDetail
import com.glengarry.app.ui.component.CategoryLabel
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.theme.darkBlue

@ExperimentalLayoutApi
@Composable
fun DetailElectronicHeader(
    modifier: Modifier = Modifier,
    details: ElectronicDetail
) {

    val detail = FashionDetail(
        label = listOf("Electronic")
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {

        AsyncImage(
            model = details.img,
            contentDescription = details.img,
            placeholder = painterResource(id = R.drawable.logo_electronic),
            error = painterResource(id = R.drawable.logo_electronic),
            modifier = Modifier
                .fillMaxWidth()
                .size(200.dp)
                .background(Color.White)
        )
        FlowRow(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            maxItemsInEachRow = 4
        ) {
            detail.label.forEach {
                CategoryLabel(
                   detail = detail
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        BaseText(
            text = details.price.toRupiah(),
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            color = darkBlue,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        BaseText(
            text = details.name,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        BaseText(
            text = "⭐ ${details.rating}",
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
//        BaseText(
//            text = detail.detailProduct,
//            fontWeight = FontWeight.Medium,
//            fontSize = 16.sp,
//            color = Color.Black
//        )
//        BaseText(
//            text = detail.detailProduct,
//            fontWeight = FontWeight.Medium,
//            fontSize = 16.sp,
//            color = Color.Black
//        )
    }

}

@ExperimentalLayoutApi
@Preview
@Composable
fun DetailElectronicHeaderPreview() {
    GlengarryTheme {
        Surface {

            val detail = ElectronicDetail(
                id = "",
                img = "",
                label = listOf("Fashion","Electronic","Book","Sport"),
                price = 200_000.0,
                name = "Product Name",
                rating = 4.3
            )

            DetailElectronicHeader(
                modifier = Modifier.padding(20.dp),
                details = detail
            )
        }
    }
}