package com.example.stylehub.presentation.productdetail.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stylehub.core.ui.theme.offWhiteColor
import com.example.stylehub.core.ui.theme.placeHolderColor
import com.example.stylehub.core.ui.theme.secondaryColor
import com.example.stylehub.domain.models.ProductModel
import com.example.stylehub.domain.models.productsTest
import kotlinx.coroutines.launch

@Composable
fun Img(
    modifier: Modifier = Modifier,
    productImages: ProductModel
) {

    val pagerState = rememberPagerState(
        pageCount = { productImages.images.size }
    )
    val coroutineScope = rememberCoroutineScope()
    val localContext = LocalContext.current


    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        HorizontalPager(
            state = pagerState,
            pageSpacing = 16.dp,
            verticalAlignment = Alignment.Top
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp, horizontal = 16.dp)
                    .clip(RoundedCornerShape(16.dp)),
                painter = painterResource(id = productImages.images[pagerState.currentPage]),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(productImages.images.size) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) secondaryColor else offWhiteColor

                Box(
                    modifier =
                        Modifier
                            .padding(horizontal = 6.dp)
                            .rotate(45f)
                            .background(color)
                            .border(
                                width = 1.dp,
                                color = if (pagerState.currentPage == iteration) secondaryColor else placeHolderColor,
                                shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp)
                            )
                            .size(8.dp)
                            .padding(16.dp)
                            .clickable(
                                onClick = {
                                    coroutineScope.launch {
                                        pagerState.animateScrollToPage(page = iteration)
                                    }
                                }
                            ),
                ) {

                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = productImages.title,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(com.example.stylehub.R.font.tenorsans)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                    letterSpacing = 4.sp,
                )
            )
            Spacer(modifier = Modifier.weight(1F))
            Icon(
                painter = painterResource(id = com.example.stylehub.R.drawable.export),
                contentDescription = null
            )
        }
        Text(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp),
            text = productImages.description,
            softWrap = false,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(com.example.stylehub.R.font.tenorsans)),
                fontWeight = FontWeight(400),
                color = Color(0xFF555555),
                textAlign = TextAlign.Center,
            )

        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp),
            text ="$ ${productImages.price}  ",
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(com.example.stylehub.R.font.tenorsans)),
                fontWeight = FontWeight(400),
                color = Color(0xFFDD8560),
            )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Color",
                style = TextStyle(
                    fontSize = 22.sp,
                    lineHeight = 14.sp,
                    fontFamily = FontFamily(Font(com.example.stylehub.R.font.tenorsans)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF555555),
                )
            )
             Spacer(modifier = Modifier.width(8.dp))
            val selector = remember { mutableStateOf(productImages.colors[0]) }
            for ( i in productImages.colors.indices) {
                Box(
                    modifier = Modifier
                        .background(Color.Transparent)
                        .size(32.dp)
                        .border(
                            color = if (selector.value == productImages.colors[i]) placeHolderColor else Color.Transparent,
                            width = 2.dp,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clickable(
                            onClick = {
                                selector.value = productImages.colors[i]
                            }
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .size(24.dp)
                            .background(productImages.colors[i])
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                            .clickable(
                                onClick = {
                                    selector.value = productImages.colors[i]
                                }
                            )
                            .align(Alignment.Center)

                    )
                }
                 Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}

@Preview(name = "Img")
@Composable
private fun PreviewImg(

) {
    Img(
        productImages = productsTest[0],
        modifier = Modifier.background(color = Color.White)
    )
}
