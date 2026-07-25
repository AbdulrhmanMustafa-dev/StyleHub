package com.example.stylehub.presentation.cart

import com.example.stylehub.domain.models.ProductModel


/**
 * UI State that represents CartScreen
 **/
sealed interface UIState<out T> {
    data object Loading : UIState<Nothing>
    data class Success<T>(val data: T) : UIState<T>
    data class Error(val message: String) : UIState<Nothing>
}

data class CartState(
    val productInCartState: UIState<List<ProductModel>> = UIState.Loading
)

/**
 * Cart Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class CartActions(
    val onBackClick: () -> Unit = {},
    val onAddClick: () -> Unit = {},
    val onMinusClick: () -> Unit = {},
    val continueShoppingClick: () -> Unit = {},
    val buyNowClick: () -> Unit = {}
)
