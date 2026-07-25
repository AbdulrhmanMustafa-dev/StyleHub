package com.example.stylehub.presentation.productdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.stylehub.domain.models.AlsoLikeProduct
import com.example.stylehub.domain.models.ProductModel
import com.example.stylehub.domain.models.productsTest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val passedProductId =
        checkNotNull(savedStateHandle.get<String>("productID")) { "Product ID is missing" }.toInt()
    val selectedProduct = productsTest.find { it.id == passedProductId } ?: productsTest[0]
    val alsoLikeProduct = AlsoLikeProduct(
        selectedProduct = selectedProduct,
        alsoLikeProduct = productsTest
    )

    init {
        print("Selected Product: $selectedProduct")
    }

    private val _stateFlow: MutableStateFlow<ProductDetailState> =
        MutableStateFlow(
            ProductDetailState(
                ProductState = UiState.Success<ProductModel>(
                    data = selectedProduct
                ),
                MayLikesProducts = UiState.Success<AlsoLikeProduct>(
                    data = alsoLikeProduct
                )
            ),


            )

    val stateFlow: StateFlow<ProductDetailState> = _stateFlow.asStateFlow()


}
