package com.example.stylehub.presentation.productdetail

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.stylehub.domain.models.Instruction
import com.example.stylehub.domain.models.ProductModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _stateFlow: MutableStateFlow<ProductDetailState> =
        MutableStateFlow(
            ProductDetailState(
                ProductState = UiState.Success<ProductModel>(
                    data = ProductModel(
                        id = 1,
                        title = "Men's Casual Shirt",
                        images = listOf(
                            com.example.stylehub.R.drawable.rectangle_325,
                            com.example.stylehub.R.drawable.image_10,
                            com.example.stylehub.R.drawable.ic_launcher_background,
                        ),
                        price = 29.99,
                        description = "A stylish and comfortable casual shirt for men, perfect for everyday wear. Made from high-quality materials, this shirt offers a great fit and durability. Available in various sizes and colors to suit your style.",
                        category = "Men's Clothing",
                        brand = "FashionCo",
                        rating = 4.5,
                        stock = 50,
                        colors = listOf(Color.Red, Color.Green, Color.Blue),
                        materials = "We work with monitoring programmes to ensure compliance with safety, health and quality standards for our products.",
                        care = "To keep your jackets and coats clean, you only need to freshen them up and go over them with a cloth or a clothes brush. If you need to dry clean a garment, look for a dry cleaner that uses technologies that are respectful of the environment.",
                        instruction = listOf(
                            Instruction(
                                string = "Do not use bleach",
                                icon = com.example.stylehub.R.drawable.do_not_bleach.toString()
                            ),
                            Instruction(
                                string = "Do not tumble dry",
                                icon = com.example.stylehub.R.drawable.do_not_tumble_dry.toString()
                            ),
                            Instruction(
                                string = "Dry clean with tetrachloroethylene",
                                icon = com.example.stylehub.R.drawable.do_not_wash.toString()
                            )
                        )
                    )
                )
            )
        )

    val stateFlow: StateFlow<ProductDetailState> = _stateFlow.asStateFlow()


}
