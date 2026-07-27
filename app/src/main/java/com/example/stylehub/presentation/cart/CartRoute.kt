package com.example.stylehub.presentation.cart

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember


@Composable
fun CartRoute(
    coordinator: CartCoordinator = rememberCartCoordinator(),
    onBackClick: () -> Unit,
    continueShoppingClick: () -> Unit,
) {
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsState(CartState())

    // UI Actions
    val actions = rememberCartActions(coordinator, onBackClick, continueShoppingClick)

    // UI Rendering
    CartScreen(uiState, actions)
}


@Composable
fun rememberCartActions(
    coordinator: CartCoordinator, onBackClick: () -> Unit, continueShoppingClick: () -> Unit

): CartActions {
    return remember(coordinator, onBackClick, continueShoppingClick) {
        CartActions(
            onBackClick = onBackClick,
            onAddClick = { productID ->
                coordinator.viewModel.increaseQuantity(productID)
            },
            onMinusClick = { productID ->
                coordinator.viewModel.decreaseQuantity(productID)
            },
            continueShoppingClick = continueShoppingClick
        )
    }
}
