package com.example.stylehub.domain

data class ProductModel(
    val title: String,
    val image: Int,
    val price: Double,
    val description: String?
)

val ProductsTest = mutableListOf<ProductModel>(
    ProductModel(
        title = "Men's Casual Shirt",
        image = com.example.stylehub.R.drawable.rectangle_325,
        price = 29.99,
        description = "A stylish and comfortable casual shirt for men, perfect for everyday"
    ),
    ProductModel(
        title = "Women's Summer Dress",
        image = com.example.stylehub.R.drawable.image_10,
        price = 49.99,
        description = "A beautiful summer dress for women, ideal"
    ),
    ProductModel(
        title = "Women's Summer Dress",
        image = com.example.stylehub.R.drawable.image_10,
        price = 49.99,
        description = "A beautiful summer dress for women, ideal"
    ),
    ProductModel(
        title = "Men's Casual Shirt",
        image = com.example.stylehub.R.drawable.image_10,
        price = 29.99,
        description = "A stylish and comfortable casual shirt for men, perfect for everyday"
    ),
    ProductModel(
        title = "Women's Summer Dress",
        image = com.example.stylehub.R.drawable.image_10,
        price = 49.99,
        description = "A beautiful summer dress for women, ideal"
    ),
    ProductModel(
        title = "Women's Summer Dress",
        image = com.example.stylehub.R.drawable.image_10,
        price = 49.99,
        description = "A beautiful summer dress for women, ideal"
    ), ProductModel(
        title = "Men's Casual Shirt",
        image = com.example.stylehub.R.drawable.image_10,
        price = 29.99,
        description = "A stylish and comfortable casual shirt for men, perfect for everyday"
    ),
    ProductModel(
        title = "Women's Summer Dress",
        image = com.example.stylehub.R.drawable.image_10,
        price = 49.99,
        description = "A beautiful summer dress for women, ideal"
    ),
    ProductModel(
        title = "Women's Summer Dress",
        image = com.example.stylehub.R.drawable.image_10,
        price = 49.99,
        description = "A beautiful summer dress for women, ideal"
    )


)
