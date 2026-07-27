package com.example.stylehub.presentation.cart

import com.example.stylehub.domain.UiCases.UIState
import com.example.stylehub.domain.models.ProductModel


/**
 * UI State that represents CartScreen
 **/


data class CartState(
    val productInCartState: UIState<List<ProductModel>> = UIState.Loading
)

/**
 * Cart Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class CartActions(
    val onBackClick: () -> Unit = {},
    val onAddClick: (Int) -> Unit = {},
    val onMinusClick: (Int) -> Unit = {},
    val continueShoppingClick: () -> Unit = {},
    val buyNowClick: () -> Unit = {}
)
