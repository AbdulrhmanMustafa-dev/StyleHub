package com.example.stylehub.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
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


@Composable
fun NewArrival(
    modifier: Modifier = Modifier,
    newArrivalItem: List<String>,
    brands: List<Int>,
    productsTest: List<com.example.stylehub.domain.models.ProductModel>
) {

    val localContext = androidx.compose.ui.platform.LocalContext.current
    val coroutineScope = androidx.compose.runtime.rememberCoroutineScope()
    val currentIndex = remember {
        androidx.compose.runtime.mutableStateOf(0)
    }
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
            horizontalArrangement = Arrangement.spacedBy(8.dp),


            ) {
            items(newArrivalItem.size) { index ->
                val isSelected = index == currentIndex.value

                Column(
                    modifier = Modifier,
                ) {
                    Text(
                        text = newArrivalItem[index],
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .clickable(
                                onClick = {
                                    currentIndex.value = index
                                }
                            ),
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 14.84.sp,
                            fontFamily = FontFamily(Font(R.font.tenorsans)),
                            fontWeight = FontWeight(400),
                            color = if (isSelected) Color(0xFF212806) else Color(0xFF888888),
                            textAlign = TextAlign.Center,
                            letterSpacing = 1.sp,
                        )
                    )
                    if (isSelected) {
                        Box(
                            modifier =
                                Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .size(6.dp) // حجم المربع
                                    .rotate(45f)
                                    .background(Color(0xFFDD8560))
                                    .padding(top = 6.dp)


                        )
                    }
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
            for (i in productsTest.indices) {
                Product(product = productsTest[i], modifier = Modifier.weight(1f))
            }
        }
        Spacer(modifier = modifier.height(16.dp))

        TextButton(
            onClick = { /* TODO: te to collection */ },
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
