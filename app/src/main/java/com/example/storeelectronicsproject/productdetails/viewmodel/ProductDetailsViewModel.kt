package com.example.storeelectronicsproject.productdetails.viewmodel

import androidx.lifecycle.ViewModel
import com.example.storeelectronicsproject.common.flow.createSharedFlow
import com.example.storeelectronicsproject.common.navigation.NavCommand
import com.example.storeelectronicsproject.productdetails.model.DetailsData
import com.example.storeelectronicsproject.productdetails.model.DetailsOnBoardingData
import com.example.storeelectronicsproject.productdetails.model.DetailsShopData
import kotlinx.coroutines.flow.*

class ProductDetailsViewModel(
    private val getDetails: DetailsUseCase,
    private val getDetailsShop: DetailsShopUseCase,
    private val getDetailsOnBoarding: DetailsOnBoardingUseCase,
    private val navigatorHomeStore: DetailsHomeStoreNavigatorUseCase
) : ViewModel() {

    private var _detailsData: MutableStateFlow<DetailsData> =
        MutableStateFlow(DetailsData("", 0, 0, 0, 0.0))
    val detailsData: StateFlow<DetailsData> get() = _detailsData.asStateFlow()

    private var _detailsShopData: MutableStateFlow<DetailsShopData> =
        MutableStateFlow(DetailsShopData("", "", "", ""))
    val detailsShopData: StateFlow<DetailsShopData> get() = _detailsShopData.asStateFlow()

    private var _detailsOnBoarding: MutableStateFlow<DetailsOnBoardingData> =
        MutableStateFlow(DetailsOnBoardingData(0, ""))
    val detailsOnBoarding: StateFlow<DetailsOnBoardingData> get() = _detailsOnBoarding.asStateFlow()

    private val _navCommand: MutableSharedFlow<NavCommand> = createSharedFlow()
    val navCommand: SharedFlow<NavCommand> get() = _navCommand.asSharedFlow()

    fun loadDetails() {
        _detailsData.tryEmit(getDetails())
    }

    fun loadDetailsShop() {
        _detailsShopData.tryEmit(getDetailsShop())
    }

    fun loadDetailsOnBoarding() {
        _detailsOnBoarding.tryEmit(getDetailsOnBoarding())
    }

    fun navigateToHomeStore() {
        _navCommand.tryEmit(navigatorHomeStore())
    }

}