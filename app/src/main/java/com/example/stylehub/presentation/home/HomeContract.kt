package com.example.stylehub.presentation.home

import com.example.stylehub.domain.models.BannerModel
import com.example.stylehub.domain.models.NewArrivalData
import com.example.stylehub.domain.models.ProductModel
import com.example.stylehub.domain.models.TrendingModel


/**
 * UI State that represents HomeScreen
 *
 **/
sealed interface UiState<out T> {
    data object Loading : UiState<Nothing>
    data class Success<T>(val data: T) : UiState<T>
    data class Error(val message: String) : UiState<Nothing>
}

data class HomeState(
    val bannerState: UiState<List<BannerModel>> = UiState.Loading,
    val newArrivalState: UiState<NewArrivalData> = UiState.Loading,
    val forYouState: UiState<List<ProductModel>> = UiState.Loading,
    val trendingState: UiState<List<TrendingModel>> = UiState.Loading,

    )

/**
 * Home Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class HomeActions(
    val onClick: () -> Unit = {}
)
