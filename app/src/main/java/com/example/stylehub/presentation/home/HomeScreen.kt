package com.example.stylehub.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.stylehub.core.common.Footer
import com.example.stylehub.core.common.Header
import com.example.stylehub.presentation.home.components.ForYou
import com.example.stylehub.presentation.home.components.HeroBanner
import com.example.stylehub.presentation.home.components.NewArrival
import com.example.stylehub.presentation.home.components.Trending

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    state: HomeState,
    actions: HomeActions,
) {
    Scaffold(
        topBar = {
            Header(title = "Home", onCartClick = actions.onCartClick)
        },
    ) { innerPadding ->
        LazyColumn(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier =
                Modifier
                    .padding(innerPadding)

            ,
        ) {
            item {
                when (val state = state.bannerState) {
                    is UiState.Success -> {
                        HeroBanner(bannerList = state.data)
                    }

                    is UiState.Loading -> {
                        CircularProgressIndicator()
                    }

                    is UiState.Error -> {

                    }
                }

                when (val state = state.newArrivalState) {
                    is UiState.Success -> {
                        NewArrival(
                            newArrivalItem = state.data.categories,
                            brands = state.data.brands,
                            productsTest = state.data.products,
                            onProductClicked = actions.onProductClick
                        )
                    }

                    is UiState.Loading -> {
                        CircularProgressIndicator()
                    }

                    is UiState.Error -> {

                    }
                }

                when (val state = state.forYouState) {
                    is UiState.Success -> {
                        ForYou(
                            productModel = state.data,
                            onProductClicked = actions.onProductClick
                        )
                    }

                    is UiState.Loading -> {
                        CircularProgressIndicator()
                    }

                    is UiState.Error -> {

                    }
                }

                when (val state = state.trendingState) {
                    is UiState.Success -> {
                        Trending(
                            trendingListTist = state.data
                        )
                    }

                    is UiState.Loading -> {
                        CircularProgressIndicator()
                    }

                    is UiState.Error -> {

                    }
                }

                Footer()
            }

        }
    }
}


@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        state = HomeState(),
        actions = HomeActions()
    )
}
