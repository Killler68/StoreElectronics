package com.example.storeelectronicsproject.mycart.viewmodel

import androidx.lifecycle.ViewModel
import com.example.storeelectronicsproject.common.flow.createSharedFlow
import com.example.storeelectronicsproject.common.navigation.NavCommand
import com.example.storeelectronicsproject.mycart.model.BasketData
import com.example.storeelectronicsproject.mycart.model.MyCartData
import kotlinx.coroutines.flow.*

class MyCartViewModel(
    private val getBasket: BasketUseCase,
    private val getMyCart: MyCartUseCase,
    private val navigatorHomeStore: MyCartHomeStoreNavigatorUseCase
) : ViewModel() {

    private var _basket: MutableStateFlow<List<BasketData>> = MutableStateFlow(emptyList())
    val basket: StateFlow<List<BasketData>> get() = _basket.asStateFlow()

    private var _myCart: MutableStateFlow<MyCartData> = MutableStateFlow(MyCartData(0, "", 0))
    val myCart: StateFlow<MyCartData> get() = _myCart.asStateFlow()

    private val _navCommand: MutableSharedFlow<NavCommand> = createSharedFlow()
    val navCommand: SharedFlow<NavCommand> get() = _navCommand.asSharedFlow()

    fun loadBasket() {
        _basket.tryEmit(getBasket())
    }

    fun loadMyCart() {
        _myCart.tryEmit(getMyCart())
    }

    fun navigationToHomeStore() {
        _navCommand.tryEmit(navigatorHomeStore())
    }

}