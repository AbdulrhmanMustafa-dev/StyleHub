package com.example.stylehub.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.stylehub.core.common.Footer
import com.example.stylehub.core.common.Header
import com.example.stylehub.presentation.home.components.HeroBanner
import com.example.stylehub.presentation.home.components.NewArrival

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    state: HomeState,
    actions: HomeActions,
) {
    Scaffold(
        topBar = {
            Header(title = "Home")
        },
    ) { innerPadding ->
        LazyColumn(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier =
                Modifier
                    .padding(innerPadding),
        ) {
            item {
                HeroBanner()
            }
            item {
                NewArrival()
            }
            item {
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
