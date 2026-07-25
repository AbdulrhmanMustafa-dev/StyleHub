package com.example.stylehub.domain.models

data class ProductModel(
    val id: Int,
    val title: String,
    val images: List<Int>,
    val price: Double,
    val description: String,
    val category: String,
    val brand: String,
    val rating: Double,
    val stock: Int,
    val colors: List<String> = listOf("#FF0000", "#00FF00", "#0000FF"),
    val sizes: List<String> = listOf("S", "M", "L", "XL"),
    val materials: String? = null,
    val care: String? = null,
    val instruction: List<Instruction>? = null,
    val numberINCart: Int? = 0

)

val productsTest = mutableListOf<ProductModel>(
    ProductModel(
        id = 1,
        title = "Men's Casual Shirt",
        images = listOf(
            com.example.stylehub.R.drawable.rectangle_325,
            com.example.stylehub.R.drawable.image_10,
            com.example.stylehub.R.drawable.ic_launcher_background,
        ),
        price = 29.99,
        description = "A stylish and comfortable casual shirt for men, perfect for everyday wear. Made from high-quality materials, this shirt offers a great fit and durability. Available in various sizes and colors to suit your style.",
        category = "Men's Clothing",
        brand = "FashionCo",
        rating = 4.5,
        stock = 50,
        colors = listOf("#FF0000", "#00FF00", "#0000FF"),
        materials = "100% Cotton",
        care = "Machine wash cold, tumble dry low, iron on low heat.",
        instruction = listOf(
            Instruction(
                icon = com.example.stylehub.R.drawable.do_not_wash,
                string = "Machine wash cold"
            ),
            Instruction(
                icon = com.example.stylehub.R.drawable.do_not_bleach,
                string = "Tumble dry low"
            ),
            Instruction(
                icon = com.example.stylehub.R.drawable.listview,
                string = "Iron on low heat"
            )
        )
    ),
    ProductModel(
        id = 2,
        title = "Women's Summer Dress",
        images = listOf(
            com.example.stylehub.R.drawable.rectangle_325,
            com.example.stylehub.R.drawable.image_10,
            com.example.stylehub.R.drawable.ic_launcher_background,
        ),
        price = 39.99,
        description = "A beautiful and comfortable summer dress for women, perfect for warm weather. Made from high-quality materials, this dress offers a great fit and durability. Available in various sizes and colors to suit your style.",
        category = "Women's Clothing",
        brand = "FashionCo",
        rating = 4.7,
        stock = 30
    ),
    ProductModel(
        id = 3,
        title = "Men's Formal Pants",
        images = listOf(
            com.example.stylehub.R.drawable.rectangle_325,
            com.example.stylehub.R.drawable.image_10,
            com.example.stylehub.R.drawable.ic_launcher_background,
        ),
        price = 49.99,
        description = "Elegant and comfortable formal pants for men, perfect for business or special occasions. Made from high-quality materials, these pants offer a great fit and durability. Available in various sizes and colors to suit your style.",
        category = "Men's Clothing",
        brand = "FashionCo",
        rating = 4.6,
        stock = 25
    ),
    ProductModel(

        id = 4,
        title = "Women's Evening Gown",
        images = listOf(
            com.example.stylehub.R.drawable.rectangle_325,
            com.example.stylehub.R.drawable.image_10,
            com.example.stylehub.R.drawable.ic_launcher_background,
        ),
        price = 79.99,
        description = "A stunning and elegant evening gown for women, perfect for formal events or special occasions. Made from high-quality materials, this gown offers a great fit and durability. Available in various sizes and colors to suit your style.",
        category = "Women's Clothing",
        brand = "FashionCo",
        rating = 4.8,
        stock = 15
    )
)
