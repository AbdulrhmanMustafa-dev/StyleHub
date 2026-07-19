package com.example.stylehub.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stylehub.R
import com.example.stylehub.domain.ProductsTest

@Composable
fun NewArrival(
    modifier: Modifier = Modifier
) {
    val newArrivalItem = mutableListOf<String>(
        "All",
        "Apparel",
        "Dress",
        "Tshirt",
        "Jeans",
        "Shoes",
        "Bag",
    )
    val brands = mutableListOf<Int>(
        R.drawable.boss,
        R.drawable.burberry,
        R.drawable.gucci,
        R.drawable.prada,
        R.drawable.tiffany___co,
        R.drawable.catier
    )
    Column(
        modifier =
            Modifier
                .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "New Arrival",
            modifier = modifier
                .padding(top = 16.dp, bottom = 8.dp),
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 40.sp,
                fontFamily = FontFamily(Font(R.font.tenorsans)),
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center,
                letterSpacing = 4.sp,
            )
        )
        Spacer(modifier = modifier.height(8.dp))
        Image(
            painter = painterResource(R.drawable._8),
            contentDescription = null
        )
        Spacer(modifier = modifier.height(8.dp))
        LazyRow(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items(newArrivalItem.size) { index ->
                if (index == 0) {
                    Text(
                        text = newArrivalItem[index],
                        modifier = Modifier.padding(horizontal = 8.dp),
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 14.84.sp,
                            fontFamily = FontFamily(Font(R.font.tenorsans)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF212806),
                            textAlign = TextAlign.Center,
                            letterSpacing = 1.sp,
                        )
                    )
                } else {
                    Text(
                        text = newArrivalItem[index],
                        modifier = Modifier.padding(horizontal = 8.dp),
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 14.84.sp,
                            fontFamily = FontFamily(Font(R.font.tenorsans)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF888888),
                            textAlign = TextAlign.Center,
                            letterSpacing = 1.sp,
                        )
                    )
                }
            }

        }
        Spacer(modifier = modifier.height(16.dp))
        FlowRow(
            modifier =
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            maxItemsInEachRow = 2
        ) {
            for (i in ProductsTest.indices) {
                Product(product = ProductsTest[i], modifier = Modifier.weight(1f))
            }
        }
        Spacer(modifier = modifier.height(16.dp))

        TextButton(
            onClick = { /* TODO: Navigate to collection */ },
            modifier = modifier
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "Explore More", style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily(Font(R.font.tenorsans)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    )
                )
                Spacer(modifier = modifier.width(8.dp))
                Icon(
                    painter = painterResource(R.drawable.forward_arrow),
                    contentDescription = null
                )
            }
        }
        Spacer(modifier = modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable._8),
            contentDescription = null,
        )
        Spacer(modifier = modifier.height(16.dp))
        FlowRow(
            modifier =
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(
                32.dp,
                alignment = Alignment.CenterHorizontally
            ),
            verticalArrangement = Arrangement.spacedBy(
                24.dp,
                alignment = Alignment.CenterVertically
            ),
            maxItemsInEachRow = 3
        ) {
            for (i in brands.indices) {
                Image(
                    painter = painterResource(id = brands[i]),
                    contentDescription = null,
                )
            }
        }
        Spacer(modifier = modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable._8),
            contentDescription = null,
        )

    }
}
