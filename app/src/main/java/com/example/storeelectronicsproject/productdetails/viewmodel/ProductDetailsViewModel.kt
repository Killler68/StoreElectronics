package com.example.storeelectronicsproject.productdetails.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coinproject.common.rx.plusAssign
import com.example.storeelectronicsproject.common.flow.createSharedFlow
import com.example.storeelectronicsproject.common.navigation.NavCommand
import com.example.storeelectronicsproject.common.state.State
import com.example.storeelectronicsproject.productdetails.model.DetailsData
import com.example.storeelectronicsproject.productdetails.model.DetailsImagesData
import com.example.storeelectronicsproject.productdetails.model.DetailsShopData
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.flow.*

class ProductDetailsViewModel(
    private val getDetails: DetailsUseCase,
    private val getDetailsShop: DetailsShopUseCase,
    private val getDetailsOnBoarding: DetailsImagesUseCase,
    private val navigatorHomeStore: DetailsHomeStoreNavigatorUseCase
) : ViewModel() {

    private var _details: MutableStateFlow<DetailsData> =
        MutableStateFlow(DetailsData("", "", emptyList(), emptyList(), 0, 0.0))
    val details: StateFlow<DetailsData> get() = _details.asStateFlow()

    private var _detailsShop: MutableStateFlow<DetailsShopData> =
        MutableStateFlow(DetailsShopData("", "", "", ""))
    val detailsShop: StateFlow<DetailsShopData> get() = _detailsShop.asStateFlow()

    private var _detailsImages: MutableStateFlow<List<DetailsImagesData>> =
        MutableStateFlow(emptyList())
    val detailsImages: StateFlow<List<DetailsImagesData>> get() = _detailsImages.asStateFlow()

    private val _navCommand: MutableSharedFlow<NavCommand> = createSharedFlow()
    val navCommand: SharedFlow<NavCommand> get() = _navCommand.asSharedFlow()

    private var _screenState: MutableLiveData<State> = MutableLiveData()
    val screenState: LiveData<State> get() = _screenState

    private var compositeDisposable = CompositeDisposable()

    fun loadDetails(id: Int) {
        _screenState.postValue(State.Loading)
        compositeDisposable += getDetails()
            .subscribe({
                _details.tryEmit(it)
                _screenState.postValue(State.Loaded)

            }, {
                _screenState.postValue(State.Error)
            })
    }

    fun loadDetailsShop() {
        compositeDisposable += getDetailsShop()
            .subscribe({
                _detailsShop.tryEmit(it)
            }, {
                _screenState.postValue(State.Error)
            })
    }

    fun loadDetailsImages() {
        compositeDisposable += getDetailsOnBoarding()
            .subscribe({
                _detailsImages.tryEmit(it)
            }, {
                _screenState.postValue(State.Error)
            })
    }

    fun navigateToHomeStore() {
        _navCommand.tryEmit(navigatorHomeStore())
    }

}