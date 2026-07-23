package com.example.stylehub.presentation.productdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.stylehub.core.common.Header

@Composable
fun ProductDetailScreen(
    state: ProductDetailState,
    actions: ProductDetailActions
) {
    Scaffold(
        topBar = {
            Header(title = "Product Detail")
        }
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(innerPadding)
        ) {
            // TODO Add UI content here
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
