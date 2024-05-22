package com.glengarry.app.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.common.toRupiah
import com.core.domain.model.ServiceItem
import com.core.domain.model.ServiceType
import com.glengarry.app.R
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme

@Composable
fun CardItem(
    modifier: Modifier = Modifier,
    needItem: ServiceItem,
    onClick: (ServiceItem) -> Unit = {}
) {

    val logo = when(needItem.type){
        ServiceType.FASHION -> R.drawable.logo_fashion
        ServiceType.ELECTRONIC -> R.drawable.logo_electronic
        ServiceType.BOOK -> R.drawable.logo_book
        else -> R.drawable.logo_sport
    }

    Column(
        modifier = modifier
            .border(width = 1.dp, shape = RoundedCornerShape(10.dp), color = Color(0xFF4D4D4D))
            .clip(RoundedCornerShape(10.dp))
            .clickable { onClick }
            .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 5.dp)
    ) {
        BaseText(
            text = needItem.serviceType,
            fontWeight = FontWeight.Medium,
            fontSize = 7.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row (verticalAlignment = Alignment.CenterVertically){
            AsyncImage(
                model = needItem.logo,
                contentDescription = "logo",
                modifier = Modifier
                    .shadow(
                        elevation = 1.dp,
                        ambientColor = Color(0x40000000),
                        spotColor = Color(0x40000000)
                    )
                    .size(30.dp)
                    .clip(RoundedCornerShape(10.dp)),
                placeholder = painterResource(id = logo),
                error = painterResource(id = logo)
            )
            Spacer(modifier = Modifier.width(12.dp))
            BaseText(
                text = needItem.title,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                color = Color(0xFF2D2D2D)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
            ){
            BaseText(
                text = needItem.minPrice.toRupiah(),
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                color = Color(0xFF080020)
            )
            BaseText(
                text = " ⭐ ${needItem.rating}",
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                color = Color(0xFF787878)
            )
        }
    }

}

@Preview
@Composable
fun CardItemPreview() {
    GlengarryTheme {
        val needItem = ServiceItem(
            id = "1",
            logo = "",
            title = "Brand Update",
            rating = 4.9,
            minPrice = 100_000.00,
            serviceType = "Fashion"
        )
        Surface {
            Row (
                modifier = Modifier.padding(horizontal = 16.dp)
            ){
                CardItem(
                    needItem = needItem,
                    modifier =  Modifier.weight(5f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                CardItem(
                    needItem = needItem,
                    modifier =  Modifier.weight(1f)
                )

            }
        }
    }
}