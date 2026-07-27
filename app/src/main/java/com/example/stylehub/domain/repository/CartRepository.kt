package com.example.stylehub.domain.repository

import com.example.stylehub.data.local.cartProduct.CartEntity
import kotlinx.coroutines.flow.Flow


interface CartRepository {
    suspend fun insertCartProduct(cartEntity: CartEntity)
    suspend fun deleteCartProduct(cartEntity: CartEntity)
    suspend fun getAllCartProducts(): Flow<List<CartEntity>>
    suspend fun updateCartProduct(cartEntity: CartEntity)
}
