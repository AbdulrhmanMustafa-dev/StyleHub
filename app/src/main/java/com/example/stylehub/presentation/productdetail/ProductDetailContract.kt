package com.example.stylehub.presentation.productdetail

import com.example.stylehub.domain.models.ProductModel


/**
 * UI State that represents ProductDetailScreen
 **/
sealed interface UiState<out T> {
    data object Loading : UiState<Nothing>
    data class Success<T>(val data: T) : UiState<T>
    data class Error(val message: String) : UiState<Nothing>
}

data class ProductDetailState(
    val ProductState: UiState<ProductModel> = UiState.Loading
)

/**
 * ProductDetail Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class ProductDetailActions(
    val onClick: () -> Unit = {}
)
