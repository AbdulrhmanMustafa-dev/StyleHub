package com.example.stylehub.presentation.cart.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.stylehub.core.ui.theme.body
import com.example.stylehub.core.ui.theme.label
import com.example.stylehub.core.ui.theme.primaryColor
import com.example.stylehub.core.ui.theme.titleActive
import com.example.stylehub.domain.models.ProductModel
import com.example.stylehub.domain.models.productsTest
import com.example.stylehub.R as RS

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    product: ProductModel,
    onAddClick: () -> Unit,
    onMinusClick: () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            modifier= Modifier
                .padding(start = 16.dp, end = 16.dp)
                .weight(.5F),
            painter = painterResource(id = product.images[0]),
            contentDescription = product.description,
            contentScale = androidx.compose.ui.layout.ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .weight(1F)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = product.title,
                // Sub-Title 14px
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                        fontFamily = FontFamily(Font(RS.font.tenorsans)),
                    fontWeight = FontWeight(400),
                    color = titleActive,
                    letterSpacing = 2.sp,
                )
            )
            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = product.description,
                softWrap = false,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    fontFamily = FontFamily(Font(RS.font.tenorsans)),
                    fontWeight = FontWeight(400),
                    color = label,
                )
            )
            Row(
                modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Remove,
                    contentDescription = "Minus",
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .clickable(
                            onClick = onMinusClick
                        )
                )
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = product.numberINCart?.toString() ?: "0",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontFamily = FontFamily(Font(RS.font.tenorsans)),
                        fontWeight = FontWeight(400),
                        color = titleActive,
                        letterSpacing = 2.sp,
                    )
                )
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Plus",
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .clickable(
                            onClick = onAddClick
                        )
                )

            }
            Row(
                modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .size(16.dp)
                        .background(Color(product.selectedColor?.toColorInt() ?: product.colors[0].toColorInt()))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                        .align (Alignment.CenterVertically)

                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .wrapContentSize(
                            Alignment.Center
                        )
                        .background( body)
                        .border(
                            color = (body) ,
                            width = 2.dp,
                            shape = RoundedCornerShape(16.dp)
                        )

                        .padding(horizontal = 8.dp, vertical = 4.dp)



                ) {
                    Text(
                        text = product.selectedSize.toString(),
                        modifier = Modifier.align(Alignment.Center),
                        style = TextStyle(
                            fontSize = 10.sp,
                            lineHeight = 12.sp,
                            fontFamily = FontFamily(Font(com.example.stylehub.R.font.tenorsans)),
                            fontWeight = FontWeight(400),
                            color = (Color.White),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
            }
            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = product.price.toString(),

                // Price
                style = TextStyle(
                    fontSize = 15.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily(Font(RS.font.tenorsans)),
                    fontWeight = FontWeight(400),
                    color = primaryColor,
                )
            )
        }
    }
}

@Preview
@Composable
private fun ProductItemPreview() {
    ProductItem(product =  productsTest[0], onMinusClick = {}, onAddClick = {})
}
