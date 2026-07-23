package com.example.stylehub.presentation.productdetail


/**
 * UI State that represents ProductDetailScreen
 **/
class ProductDetailState

/**
 * ProductDetail Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class ProductDetailActions(
    val onClick: () -> Unit = {}
)
