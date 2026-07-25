package com.example.stylehub.presentation.productdetail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stylehub.R
import com.example.stylehub.domain.models.ProductModel
import com.example.stylehub.presentation.home.components.Product

@Composable
fun AlsoLike(
    modifier: Modifier = Modifier,
    selectedProduct: ProductModel,
    alsoLikesProducts: List<ProductModel>,
    onProductClicked: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "You may also like",

            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 40.sp,
                fontFamily = FontFamily(Font(R.font.tenorsans)),
                fontWeight = FontWeight(400),
                color = Color.Black,
                letterSpacing = 4.sp,
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable._8),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(16.dp))

        FlowRow(
            modifier =
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            maxItemsInEachRow = 2
        ) {
            for (i in alsoLikesProducts.indices) {
                if (selectedProduct.brand == alsoLikesProducts[i].brand || selectedProduct.category == alsoLikesProducts[i].category) {
                    Product(
                        modifier = Modifier.weight(1f),
                        product = alsoLikesProducts[i],
                        onProductClicked = onProductClicked
                    )
                }
            }
        }
    }
}
