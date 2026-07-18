package com.example.stylehub.core.routes

sealed class Routes (val route : String) {
    data object Home : Routes(route = "home")
    data object Search : Routes(route = "search")
    data object Cart : Routes(route = "cart")
    data object Profile : Routes(route = "profile")
}
