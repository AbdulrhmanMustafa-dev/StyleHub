package com.example.stylehub.data.repositoryImpl

import com.example.stylehub.data.local.cartProduct.CartEntity
import com.example.stylehub.data.local.cartProduct.CartProductDAO
import com.example.stylehub.domain.repository.CartRepository
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val cartProductDAO: CartProductDAO
) : CartRepository {
    override suspend fun insertCartProduct(cartEntity: CartEntity) {
        cartProductDAO.insertCartProduct(cartEntity)
    }

    override suspend fun deleteCartProduct(cartEntity: CartEntity) {
        cartProductDAO.deleteCartProduct(cartEntity)
    }

    override suspend fun getAllCartProducts(): kotlinx.coroutines.flow.Flow<List<CartEntity>> {
        return cartProductDAO.getAllCartProducts()
    }

    override suspend fun updateCartProduct(cartEntity: CartEntity) {
        cartProductDAO.updateCartProduct(cartEntity)
    }
}
