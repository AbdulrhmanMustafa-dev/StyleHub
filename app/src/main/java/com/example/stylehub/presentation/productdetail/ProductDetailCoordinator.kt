package com.example.stylehub.presentation.productdetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
class ProductDetailCoordinator(
    val viewModel: ProductDetailViewModel
) {
    val screenStateFlow = viewModel.stateFlow


}

@Composable
fun rememberProductDetailCoordinator(
    viewModel: ProductDetailViewModel = hiltViewModel()
): ProductDetailCoordinator {
    return remember(viewModel) {
        ProductDetailCoordinator(
            viewModel = viewModel
        )
    }
}
