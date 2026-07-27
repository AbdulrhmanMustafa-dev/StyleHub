package com.example.stylehub.presentation.cart.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
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
import com.example.stylehub.core.ui.theme.body
import com.example.stylehub.core.ui.theme.placeHolderColor
import com.example.stylehub.core.ui.theme.titleActive
import com.example.stylehub.domain.models.ProductModel
import com.example.stylehub.domain.models.productsTest

@Composable
fun ProductList(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    productInCart: List<ProductModel>,
    onAddClick: (Int) -> Unit,
    onMinusClick: (Int) -> Unit,
    continueShoppingClick: () -> Unit,
    buyNowClick: () -> Unit
) {
    Column(
        modifier = modifier

            .fillMaxHeight(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Icon(
            modifier = Modifier
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                .clickable(
                    onClick = onBackClick
                )
                .size(32.dp),
            painter = painterResource(id = R.drawable.close),
            contentDescription = "Empty cart"

        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp),
            text = "CART",
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 34.5.sp,
                fontFamily = FontFamily(Font(R.font.tenorsans)),
                fontWeight = FontWeight(400),
                color = body,
                letterSpacing = 3.sp,

                )
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                .scrollable(
                    state = ScrollableState { 10.0.toFloat() },
                    orientation = Orientation.Vertical
                ),
        ) {
            if (productInCart.isEmpty()) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "You have no items in your Shopping Bag.",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        fontFamily = FontFamily(Font(R.font.tenorsans)),
                        fontWeight = FontWeight(400),
                        color = placeHolderColor,
                        textAlign = TextAlign.Center,
                    )
                )
            } else {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ) {
                    for (i in productInCart) {
                        ProductItem(
                            product = i,
                            onAddClick = { onAddClick(i.id) },
                            onMinusClick = { onMinusClick(i.id) }
                        )
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .background(titleActive)
                .fillMaxWidth()
                .height(60.dp),
        ) {

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(
                        onClick = if (productInCart.isEmpty()) continueShoppingClick else buyNowClick
                    )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.shopping_bag),
                    contentDescription = "Back",
                    tint = Color(0xFFFCFCFC),
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = if (productInCart.isEmpty()) "Continue Shopping" else "BUY NOW",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 26.sp,
                        fontFamily = FontFamily(Font(R.font.tenorsans)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFCFCFC),
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.16.sp,
                    )
                )

            }
        }
    }
}

@Preview(name = "EmptyList")
@Composable
private fun PreviewProductList() {
    ProductList(
        modifier = Modifier.background(color = Color.White),
        onBackClick = {},
        productInCart = productsTest,
        onAddClick = {},
        onMinusClick = {},
        continueShoppingClick = {},
        buyNowClick = {}
    )
}
