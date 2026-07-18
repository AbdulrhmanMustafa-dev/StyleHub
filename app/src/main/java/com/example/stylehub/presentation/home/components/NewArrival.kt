package com.example.stylehub.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
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
            for (i in 0 until ProductsTest.size) {
                Product(product = ProductsTest[i], modifier = Modifier.weight(1f))
            }
        }
        Spacer(modifier = modifier.height(16.dp))


    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
private fun PreviewNewArrival() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        NewArrival(

        )
    }
}
