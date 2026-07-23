package com.example.stylehub.presentation.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.stylehub.R
import com.example.stylehub.domain.models.BannerList
import com.example.stylehub.domain.models.NewArrivalData
import com.example.stylehub.domain.models.TrendingListTist
import com.example.stylehub.domain.models.productsTest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val newArrivalData = NewArrivalData(
        categories = listOf("All", "Clothes", "Shoes", "Accessories"),
        brands = listOf(R.drawable.boss, R.drawable.catier, R.drawable.gucci, R.drawable.boss),
        products = productsTest
    )
    private val _stateFlow: MutableStateFlow<HomeState> = MutableStateFlow(
        HomeState(
            bannerState = UiState.Success(BannerList),
            newArrivalState = UiState.Success(newArrivalData),
            forYouState = UiState.Success(productsTest),
            trendingState = UiState.Success(TrendingListTist)
        )
    )

    val stateFlow: StateFlow<HomeState> = _stateFlow.asStateFlow()


}
