package com.example.stylehub.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stylehub.domain.models.ProductModel

@Composable
fun ForYou(
    modifier: Modifier = Modifier,
    productModel: List<ProductModel>
) {
    val pageState = rememberPagerState(pageCount = {
        productModel.size
    })
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Just for You",
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 40.sp,
                fontFamily = FontFamily(Font(com.example.stylehub.R.font.tenorsans)),
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center,
                letterSpacing = 4.sp,
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = com.example.stylehub.R.drawable._8),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalPager(
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .padding(horizontal = 48.dp),
            state = pageState,
            contentPadding = PaddingValues(horizontal = 24.dp),
            pageSpacing = 8.dp,
        ) { page ->
            Product(
                modifier = Modifier,
                product = productModel[page]
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .padding(top = 8.dp, bottom = 16.dp)
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(productModel.size) { iteration ->
                val color =
                    if (pageState.currentPage == iteration) Color(0xFF000000) else Color(0xFFBDBDBD)
                Spacer(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .height(8.dp)
                        .clip(shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp))
                        .width(if (pageState.currentPage == iteration) 24.dp else 8.dp)
                        .background(
                            color = color,
                            shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp)
                        )
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = com.example.stylehub.R.drawable._8),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}
