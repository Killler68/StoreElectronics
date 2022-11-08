package com.example.storeelectronicsproject.productdetails.viewmodel

import androidx.lifecycle.ViewModel
import com.example.storeelectronicsproject.productdetails.model.DetailsData
import com.example.storeelectronicsproject.productdetails.model.DetailsOnBoardingData
import com.example.storeelectronicsproject.productdetails.model.DetailsShopData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductDetailsViewModel(
    private val getDetails: DetailsUseCase,
    private val getDetailsShop: DetailsShopUseCase,
    private val getDetailsOnBoarding: DetailsOnBoardingUseCase
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


    fun loadDetails() {
        _detailsData.tryEmit(getDetails())
    }

    fun loadDetailsShop() {
        _detailsShopData.tryEmit(getDetailsShop())
    }

    fun loadDetailsOnBoarding() {
        _detailsOnBoarding.tryEmit(getDetailsOnBoarding())
    }

}