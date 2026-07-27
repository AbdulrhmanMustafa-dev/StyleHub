package com.example.stylehub.presentation.productdetail

import com.example.stylehub.domain.UiCases.UIState
import com.example.stylehub.domain.models.AlsoLikeProduct
import com.example.stylehub.domain.models.ProductModel


/**
 * UI State that represents ProductDetailScreen
 **/

data class ProductDetailState(
    val ProductState: UIState<ProductModel> = UIState.Loading,
    val MayLikesProducts: UIState<AlsoLikeProduct> = UIState.Loading
)

/**
 * ProductDetail Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class ProductDetailActions(
    val onClick: () -> Unit = {},
    val onProductClicked: (Int) -> Unit = {},
    val onCartClick: () -> Unit = {},
    val onAddToCard: () -> Unit = {},

    )
