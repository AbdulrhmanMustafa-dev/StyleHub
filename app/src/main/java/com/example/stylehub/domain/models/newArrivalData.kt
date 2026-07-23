package com.example.stylehub.domain.models

data class NewArrivalData(
    val categories: List<String>,
    val brands: List<Int>,
    val products: List<ProductModel>
)
