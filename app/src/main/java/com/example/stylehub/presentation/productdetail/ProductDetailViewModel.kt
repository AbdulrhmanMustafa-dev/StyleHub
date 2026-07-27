package com.example.stylehub.presentation.productdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stylehub.data.local.cartProduct.CartEntity
import com.example.stylehub.domain.models.AlsoLikeProduct
import com.example.stylehub.domain.models.ProductModel
import com.example.stylehub.domain.models.productsTest
import com.example.stylehub.domain.repository.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val cartRepository: CartRepository
) : ViewModel() {
    val passedProductId =
        checkNotNull(savedStateHandle.get<String>("productID")) { "Product ID is missing" }.toInt()
    val selectedProduct = productsTest.find { it.id == passedProductId } ?: productsTest[0]
    val alsoLikeProduct = AlsoLikeProduct(
        selectedProduct = selectedProduct,
        alsoLikeProduct = productsTest
    )


    private val _stateFlow: MutableStateFlow<ProductDetailState> =
        MutableStateFlow(
            ProductDetailState(
                ProductState = UIState.Success<ProductModel>(
                    data = selectedProduct
                ),
                MayLikesProducts = UIState.Success<AlsoLikeProduct>(
                    data = alsoLikeProduct
                )
            ),


            )

    val stateFlow: StateFlow<ProductDetailState> = _stateFlow.asStateFlow()

    fun addToCart() {
        viewModelScope.launch {
            val cartEntity = CartEntity(
                id = selectedProduct.id,
                title = selectedProduct.title,
                images = selectedProduct.images,
                price = selectedProduct.price,
                description = selectedProduct.description,
                category = selectedProduct.category,
                brand = selectedProduct.brand,
                rating = selectedProduct.rating,
                stock = selectedProduct.stock,
                colors = selectedProduct.colors,
                sizes = selectedProduct.sizes,
                materials = selectedProduct.materials,
                care = selectedProduct.care,
                instruction = selectedProduct.instruction,
                numberINCart = 1,
                selectedSize = selectedProduct.selectedSize,
                selectedColor = selectedProduct.selectedColor
            )
            cartRepository.insertCartProduct(cartEntity = cartEntity)
        }
    }


}
