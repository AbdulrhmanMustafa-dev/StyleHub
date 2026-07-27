package com.example.stylehub.presentation.category

import com.example.stylehub.domain.UiCases.UIState


/**
 * UI State that represents CategoryScreen
 **/

data class CategoryState(
    val products: UIState<List<com.example.stylehub.domain.models.ProductModel>> = UIState.Loading,
    val hasFilter: UIState<List<String>> = UIState.Loading
)

/**
 * Category Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class CategoryActions(
    val onClick: () -> Unit = {},
    val onFilterClick :()-> Unit = {},
    val onListView :()-> Unit = {},
    val onDateClick :()-> Unit = {},
    val onFilterCloseClick :()-> Unit = {}
)
