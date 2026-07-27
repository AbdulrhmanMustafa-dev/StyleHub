package com.example.stylehub.presentation.home

import com.example.stylehub.domain.UiCases.UIState
import com.example.stylehub.domain.models.BannerModel
import com.example.stylehub.domain.models.NewArrivalData
import com.example.stylehub.domain.models.ProductModel
import com.example.stylehub.domain.models.TrendingModel


/**
 * UI State that represents HomeScreen
 *
 **/

data class HomeState(
    val bannerState: UIState<List<BannerModel>> = UIState.Loading,
    val newArrivalState: UIState<NewArrivalData> = UIState.Loading,
    val forYouState: UIState<List<ProductModel>> = UIState.Loading,
    val trendingState: UIState<List<TrendingModel>> = UIState.Loading,

    )

/**
 * Home Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class HomeActions(
    val onClick: () -> Unit = {},
    val onProductClick: (Int) -> Unit = {},
    val onCartClick : ()-> Unit = {}
)
