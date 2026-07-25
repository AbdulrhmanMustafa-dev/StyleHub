package com.example.stylehub.domain.models

data class AlsoLikeProduct(
    val selectedProduct: ProductModel,
    val alsoLikeProduct: List<ProductModel>
)
