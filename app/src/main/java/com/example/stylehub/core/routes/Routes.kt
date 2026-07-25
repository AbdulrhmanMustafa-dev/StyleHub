package com.example.stylehub.core.routes

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes(val route: String) {
    @Serializable
    data object Home : Routes(route = "home")

    @Serializable
    data object ProductDetail : Routes(route = "product_detail/{productID}") {
        fun createRoute(productID: Int) = "product_detail/${productID}"
    }

    //    @Serializable
//    data object Search : Routes(route = "search")
    @Serializable
    data object Cart : Routes(route = "cart")
//    @Serializable
//    data object Profile : Routes(route = "profile")
}
