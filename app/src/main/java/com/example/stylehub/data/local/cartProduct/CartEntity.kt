package com.example.stylehub.data.local.cartProduct

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.stylehub.domain.models.Instruction

@Entity(tableName = "cart_table")
data class CartEntity(
    @PrimaryKey val id: Int,
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
    val numberINCart: Int? = 0,
    var selectedColor: String? = colors[0],
    var selectedSize: String? = sizes[0]
)
