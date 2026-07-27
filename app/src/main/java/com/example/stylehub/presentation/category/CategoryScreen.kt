package com.example.stylehub.presentation.category

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.stylehub.core.common.Header
import com.example.stylehub.presentation.category.components.Filter

@Composable
fun CategoryScreen(
    state: CategoryState,
    actions: CategoryActions
) {
    Scaffold(
        topBar = {
            Header(
                title = "Category",
                onCartClick = {},

            )
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            item {
                Filter(
                    products = listOf(),
                    onFilterClick = {},
                    hasFilter = listOf("women", "men"),
                    onListView = {},
                    ondateClick = {},
                    onFilterCloseClick = {}
                )
            }
        }

    }
}

@Composable
@Preview(name = "Category")
private fun CategoryScreenPreview() {
    CategoryScreen(
        state = CategoryState(),
        actions = CategoryActions()
    )
}
