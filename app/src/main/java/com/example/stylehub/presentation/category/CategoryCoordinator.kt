package com.example.stylehub.presentation.category

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
class CategoryCoordinator(
    val viewModel: CategoryViewModel
) {
    val screenStateFlow = viewModel.stateFlow


}

@Composable
fun rememberCategoryCoordinator(
    viewModel: CategoryViewModel = hiltViewModel()
): CategoryCoordinator {
    return remember(viewModel) {
        CategoryCoordinator(
            viewModel = viewModel
        )
    }
}
