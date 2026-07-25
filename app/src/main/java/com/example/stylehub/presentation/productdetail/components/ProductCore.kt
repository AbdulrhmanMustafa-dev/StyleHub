package com.example.stylehub.presentation.productdetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stylehub.R
import com.example.stylehub.core.ui.theme.label
import com.example.stylehub.domain.models.ProductModel

@Composable
fun ProductCore(
    modifier: Modifier = Modifier,
    product: ProductModel
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        product.materials?.let {
            Text(
                text = "MATERIALS",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily(Font(R.font.tenorsans)),
                    fontWeight = FontWeight(400),
                    color = Color.Black,
                    letterSpacing = 2.sp,
                )
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = it,
                modifier = Modifier.padding(start = 8.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily(Font(R.font.tenorsans)),
                    fontWeight = FontWeight(400),
                    color = label,
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        product.care?.let {
            Text(
                text = "CARE",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily(Font(R.font.tenorsans)),
                    fontWeight = FontWeight(400),
                    color = Color.Black,
                    letterSpacing = 2.sp,
                )
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = it,
                modifier = Modifier.padding(start = 8.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily(Font(R.font.tenorsans)),
                    fontWeight = FontWeight(400),
                    color = label,
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        product.instruction?.let {
            Text(
                text = "INSTRUCTION",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily(Font(R.font.tenorsans)),
                    fontWeight = FontWeight(400),
                    color = Color.Black,
                    letterSpacing = 2.sp,
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            for (i in product.instruction.indices) {
                Row(
                    modifier = Modifier.padding(start = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    product.instruction[i].icon?.let { id ->
                        Icon(
                            painter = painterResource(id = id),
                            contentDescription = null
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = product.instruction[i].string!!,

                        // Body-M
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 24.sp,
                            fontFamily = FontFamily(Font(R.font.tenorsans)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF555555),
                        )
                    )
                }
            }
        }
    }
}

@Preview(name = "ProductCore", backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
private fun PreviewProductCore() {
    ProductCore(
        product = ProductModel(
            id = 1,
            title = "Men's Casual Shirt",
            images = listOf(
                R.drawable.rectangle_325,
                R.drawable.image_10,
                R.drawable.ic_launcher_background,
            ),
            price = 29.99,
            description = "A stylish and comfortable casual shirt for men, perfect for everyday wear. Made from high-quality materials, this shirt offers a great fit and durability. Available in various sizes and colors to suit your style.",
            category = "Men's Clothing",
            brand = "FashionCo",
            rating = 4.5,
            stock = 50,
            colors = listOf("#FF0000", "#00FF00", "#0000FF"),
            materials = "We work with monitoring programmes to ensure compliance with safety, health and quality standards for our products.",
            care = "To keep your jackets and coats clean, you only need to freshen them up and go over them with a cloth or a clothes brush. If you need to dry clean a garment, look for a dry cleaner that uses technologies that are respectful of the environment.",

            )
    )
}
