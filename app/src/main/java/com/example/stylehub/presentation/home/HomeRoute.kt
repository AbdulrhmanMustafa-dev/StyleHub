package com.example.stylehub.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember


@Composable
fun HomeRoute(
    coordinator: HomeCoordinator = rememberHomeCoordinator(),
    navigateToProductDetail: (Int) -> Unit = {},
    navigateToCart: () -> Unit
) {
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsState(HomeState())

    // UI Actions
    val actions = rememberHomeActions(coordinator, navigateToProductDetail,navigateToCart)

    // UI Rendering
    HomeScreen(uiState, actions)
}


@Composable
fun rememberHomeActions(
    coordinator: HomeCoordinator,
    navigateToProductDetail: (Int) -> Unit,
    navigateToCart: () -> Unit
): HomeActions {
    return remember(coordinator, navigateToProductDetail, navigateToCart) {
        HomeActions(
            onProductClick = { productID ->
                navigateToProductDetail(productID)
            },
            onCartClick = {
                navigateToCart()
            }
        )
    }
}
