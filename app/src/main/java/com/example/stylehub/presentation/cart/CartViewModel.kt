package com.example.stylehub.presentation.cart

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.stylehub.domain.models.productsTest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _stateFlow: MutableStateFlow<CartState> = MutableStateFlow(
        CartState(
            productInCartState = UIState.Success(data = productsTest)
        )
    )

    val stateFlow: StateFlow<CartState> = _stateFlow.asStateFlow()


}
