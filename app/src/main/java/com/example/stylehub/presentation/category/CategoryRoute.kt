package com.example.stylehub.presentation.category

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember


@Composable
fun CategoryRoute(
    coordinator: CategoryCoordinator = rememberCategoryCoordinator()
) {
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsState(CategoryState())

    // UI Actions
    val actions = rememberCategoryActions(coordinator)

    // UI Rendering
    CategoryScreen(uiState, actions)
}


@Composable
fun rememberCategoryActions(coordinator: CategoryCoordinator): CategoryActions {
    return remember(coordinator) {
        CategoryActions(

        )
    }
}
