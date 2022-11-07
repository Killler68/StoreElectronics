package com.example.storeelectronicsproject.mycart.viewmodel

import androidx.lifecycle.ViewModel
import com.example.storeelectronicsproject.mycart.model.BasketData
import com.example.storeelectronicsproject.mycart.model.MyCartData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MyCartViewModel(
    private val getBasket: BasketUseCase,
    private val getMyCart: MyCartUseCase
) : ViewModel() {

    private var _basket: MutableStateFlow<List<BasketData>> = MutableStateFlow(emptyList())
    val basket: StateFlow<List<BasketData>> get() = _basket.asStateFlow()

    private var _myCart: MutableStateFlow<MyCartData> = MutableStateFlow(MyCartData(0, "", 0))
    val myCart: StateFlow<MyCartData> get() = _myCart.asStateFlow()

    fun loadBasket() {
        _basket.tryEmit(getBasket())
    }

    fun loadMyCart() {
        _myCart.tryEmit(getMyCart())
    }

}