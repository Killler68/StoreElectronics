package com.example.storeelectronicsproject.mycart.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coinproject.common.rx.plusAssign
import com.example.storeelectronicsproject.common.flow.createSharedFlow
import com.example.storeelectronicsproject.common.navigation.NavCommand
import com.example.storeelectronicsproject.mycart.model.BasketData
import com.example.storeelectronicsproject.mycart.model.MyCartData
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.flow.*

class MyCartViewModel(
    private val getBasket: BasketUseCase,
    private val getMyCart: MyCartUseCase,
    private val navigatorHomeStore: MyCartHomeStoreNavigatorUseCase
) : ViewModel() {

    private var _basket: MutableStateFlow<List<BasketData>> = MutableStateFlow(emptyList())
    val basket: StateFlow<List<BasketData>> get() = _basket.asStateFlow()

    private var _myCart: MutableStateFlow<MyCartData> = MutableStateFlow(MyCartData("", "", 0))
    val myCart: StateFlow<MyCartData> get() = _myCart.asStateFlow()

    private val _navCommand: MutableSharedFlow<NavCommand> = createSharedFlow()
    val navCommand: SharedFlow<NavCommand> get() = _navCommand.asSharedFlow()

    private var _screenState: MutableLiveData<String> = MutableLiveData()
    val screenState: LiveData<String> get() = _screenState

    private var compositeDisposable = CompositeDisposable()

    fun loadBasket() {
        compositeDisposable += getBasket()
            .subscribe({
                _basket.tryEmit(it)
            }, {
                _screenState.postValue(it.toString())
            })
    }

    fun loadMyCart() {
        compositeDisposable += getMyCart()
            .subscribe({
                _myCart.tryEmit(it)
            }, {
                _screenState.postValue(it.toString())
            })
    }

    fun navigationToHomeStore() {
        _navCommand.tryEmit(navigatorHomeStore())
    }

}