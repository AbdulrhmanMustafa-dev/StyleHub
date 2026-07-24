package com.example.stylehub.presentation.productdetail

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.stylehub.core.common.Footer
import com.example.stylehub.core.common.Header
import com.example.stylehub.presentation.productdetail.components.AdderButton
import com.example.stylehub.presentation.productdetail.components.Img
import com.example.stylehub.presentation.productdetail.components.ProductCore

@Composable
fun ProductDetailScreen(
    state: ProductDetailState,
    actions: ProductDetailActions
) {
    val localContext = LocalContext.current
    Scaffold(
        topBar = {
            Header(title = "Product Detail")
        }
    ) { innerPadding ->
        LazyColumn(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            when (val state = state.ProductState) {
                is UiState.Success -> {
                    item {
                        Img(
                            productImages = state.data
                        )
                        AdderButton(
                            addButtonOnclick = {
                                Toast.makeText(
                                    localContext,
                                    "Added to cart",
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                            heartButtonOnclick = {
                                Toast.makeText(
                                    localContext,
                                    "Added to hearted items",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        )
                        ProductCore(
                            product = state.data
                        )
                    }
                }

                is UiState.Loading -> {

                }

                is UiState.Error -> {

                }
            }

            item {
                Footer()
            }
        }
    }
}

@Composable
@Preview(name = "ProductDetail")
private fun ProductDetailScreenPreview() {
    ProductDetailScreen(
        state = ProductDetailState(),
        actions = ProductDetailActions()
    )
}
