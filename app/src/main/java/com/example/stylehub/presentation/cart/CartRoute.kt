package com.example.stylehub.presentation.cart

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember


@Composable
fun CartRoute(
    coordinator: CartCoordinator = rememberCartCoordinator(),
    onBackClick: () -> Unit,
    onAddClick: () -> Unit = {},
    onMinusClick: () -> Unit = {},
) {
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsState(CartState())

    // UI Actions
    val actions = rememberCartActions(coordinator, onBackClick, onAddClick, onMinusClick)

    // UI Rendering
    CartScreen(uiState, actions)
}


@Composable
fun rememberCartActions(
    coordinator: CartCoordinator, onBackClick: () -> Unit, onAddClick: () -> Unit = {},
    onMinusClick: () -> Unit = {},
): CartActions {
    return remember(coordinator, onBackClick, onAddClick, onMinusClick) {
        CartActions(
            onBackClick = onBackClick,
            onAddClick = onAddClick,
            onMinusClick = onMinusClick
        )
    }
}
