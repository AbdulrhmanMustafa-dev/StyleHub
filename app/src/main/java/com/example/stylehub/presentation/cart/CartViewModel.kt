package com.example.stylehub.presentation.cart

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stylehub.data.local.cartProduct.CartEntity
import com.example.stylehub.domain.models.ProductModel
import com.example.stylehub.domain.repository.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val cartRepository: CartRepository
) : ViewModel() {
    private var currentCartItems: List<ProductModel> = emptyList()

    private val _stateFlow: MutableStateFlow<CartState> = MutableStateFlow(
        CartState(
            productInCartState = UIState.Loading
        )
    )

    val stateFlow: StateFlow<CartState> = _stateFlow.asStateFlow()

    init {
        getAllProducts()
    }

    private fun getAllProducts() {
        viewModelScope.launch {
            cartRepository.getAllCartProducts().collect { entities ->
                val products = entities.map { entity ->
                    ProductModel(
                        id = entity.id,
                        title = entity.title,
                        price = entity.price,
                        images = entity.images,
                        instruction = entity.instruction,
                        numberINCart = entity.numberINCart,
                        description = entity.description,
                        colors = entity.colors,
                        materials = entity.materials,
                        care = entity.care,
                        brand = entity.brand,
                        stock = entity.stock,
                        sizes = entity.sizes,
                        category = entity.category,
                        rating = entity.rating,
                        selectedSize = entity.selectedSize,
                        selectedColor = entity.selectedColor
                    )
                }
                currentCartItems = products
                updateState(products)
            }
        }
    }


    fun increaseQuantity(
        productID: Int
    ) {
        val product = currentCartItems.find { it.id == productID }
        product?.let {
            val currentQty = it.numberINCart ?: 0
            updateCartProductQuantity(product, currentQty + 1)
        }
    }

    fun decreaseQuantity(
        productID: Int
    ) {
        val product = currentCartItems.find { it.id == productID }
        product?.let {
            val currentQty = it.numberINCart ?: 0
            if (currentQty > 1) {
                updateCartProductQuantity(product, currentQty - 1)
            } else {
                removeProductFromCart(product)
            }
        }
    }

    private fun updateState(currentCartItems: List<ProductModel>) {
        _stateFlow.value = CartState(
            productInCartState = UIState.Success(data = currentCartItems)
        )
    }

    private fun updateCartProductQuantity(productModel: ProductModel, newQuantity: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val entity = CartEntity(
                id = productModel.id,
                title = productModel.title,
                price = productModel.price,
                images = productModel.images,
                instruction = productModel.instruction,
                numberINCart = newQuantity,
                description = productModel.description,
                colors = productModel.colors,
                materials = productModel.materials,
                care = productModel.care,
                brand = productModel.brand,
                stock = productModel.stock,
                sizes = productModel.sizes,
                category = productModel.category,
                rating = productModel.rating,
                selectedSize = productModel.selectedSize,
                selectedColor = productModel.selectedColor
            )
            cartRepository.updateCartProduct(cartEntity = entity)
        }
    }

    private fun removeProductFromCart(productModel: ProductModel) {
        viewModelScope.launch {
            val entity = CartEntity(
                id = productModel.id,
                title = productModel.title,
                price = productModel.price,
                images = productModel.images,
                instruction = productModel.instruction,
                numberINCart = productModel.numberINCart,
                description = productModel.description,
                colors = productModel.colors,
                materials = productModel.materials,
                care = productModel.care,
                brand = productModel.brand,
                stock = productModel.stock,
                sizes = productModel.sizes,
                category = productModel.category,
                rating = productModel.rating,
                selectedSize = productModel.selectedSize,
                selectedColor = productModel.selectedColor
            )
            cartRepository.deleteCartProduct(entity)
        }
    }
}
