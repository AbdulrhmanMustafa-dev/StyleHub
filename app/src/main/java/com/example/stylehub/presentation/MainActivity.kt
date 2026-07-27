package com.example.stylehub.presentation


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stylehub.core.routes.Routes
import com.example.stylehub.core.ui.theme.StyleHubTheme
import com.example.stylehub.presentation.cart.CartRoute
import com.example.stylehub.presentation.home.HomeRoute
import com.example.stylehub.presentation.productdetail.ProductDetailRoute
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StyleHubTheme(
                darkTheme = false
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Routes.Home.route) {
                        composable(Routes.Home.route) {
                            HomeRoute(
                                navigateToProductDetail = { productID ->
                                    navController.navigate(
                                        Routes.ProductDetail.createRoute(
                                            productID
                                        )
                                    )
                                },
                                navigateToCart = {
                                    navController.navigate(
                                        Routes.Cart.route
                                    )
                                }
                            )

                        }
                        composable(Routes.ProductDetail.route) {
                            ProductDetailRoute(
                                navigateToCart = {
                                    navController.navigate(
                                        Routes.Cart.route
                                    )
                                },
                                navigateToProductDetail = { productID ->
                                    navController.navigate(
                                        Routes.ProductDetail.createRoute(
                                            productID
                                        )
                                    )
                                }
                            )
                        }
                        composable(Routes.Cart.route) {
                            CartRoute(
                                onBackClick = {
                                    navController.popBackStack()
                                },
                                continueShoppingClick = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
