package com.example.stylehub.presentation.cart

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.stylehub.presentation.cart.components.ProductList

@Composable
fun CartScreen(
    state: CartState,
    actions: CartActions
) {
    Scaffold { innerPadding ->
        Box(

            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = androidx.compose.ui.Alignment.Center
        ) {

            when (val state = state.productInCartState) {
                is UIState.Loading -> {
                    CircularProgressIndicator()
                }

                is UIState.Success -> {
                    ProductList(
                        onBackClick = actions.onBackClick,
                        productInCart = state.data,
                        onAddClick = actions.onAddClick,
                        onMinusClick = actions.onMinusClick,
                        continueShoppingClick = actions.continueShoppingClick,
                        buyNowClick = actions.buyNowClick
                    )
                }

                is UIState.Error -> {
                    // Show error content
                }
            }

        }
    }
}

@Composable
@Preview(name = "Cart")
private fun CartScreenPreview() {
    CartScreen(
        state = CartState(),
        actions = CartActions()
    )
}
