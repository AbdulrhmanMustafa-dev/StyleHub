package com.example.stylehub.presentation.productdetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember


@Composable
fun ProductDetailRoute(
    coordinator: ProductDetailCoordinator = rememberProductDetailCoordinator()
) {
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsState(ProductDetailState())

    // UI Actions
    val actions = rememberProductDetailActions(coordinator)

    // UI Rendering
    ProductDetailScreen(uiState, actions)
}


@Composable
fun rememberProductDetailActions(coordinator: ProductDetailCoordinator): ProductDetailActions {
    return remember(coordinator) {
        ProductDetailActions(

        )
    }
}
