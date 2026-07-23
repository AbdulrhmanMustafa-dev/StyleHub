package com.example.stylehub.domain.models

data class TrendingModel(
    val id: Int,
    val title: String
)

val TrendingListTist = List(10) { index ->
    TrendingModel(
        id = index,
        title = " ${index + 1}"
    )
}
