package com.example.stylehub.domain

import com.example.stylehub.R

data class BannerModel(
    val id: Int,
    val image: Int,
)

val BannerList = mutableListOf<BannerModel>(
    BannerModel(1, R.drawable.image_10),
    BannerModel(2, R.drawable.image_10),
    BannerModel(3, R.drawable.image_10)
)
