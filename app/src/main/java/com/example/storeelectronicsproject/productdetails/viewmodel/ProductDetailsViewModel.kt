package com.example.storeelectronicsproject.productdetails.viewmodel

import androidx.lifecycle.ViewModel
import com.example.storeelectronicsproject.productdetails.model.DetailsData
import com.example.storeelectronicsproject.productdetails.model.DetailsShopData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductDetailsViewModel(
    private val getDetails: DetailsUseCase,
    private val getDetailsShop: DetailsShopUseCase
) : ViewModel() {

    private var _detailsData: MutableStateFlow<DetailsData> =
        MutableStateFlow(DetailsData("", 0, 0, 0, 0.0))
    val detailsData: StateFlow<DetailsData> get() = _detailsData.asStateFlow()

    private var _detailsShopData: MutableStateFlow<DetailsShopData> =
        MutableStateFlow(DetailsShopData("", "", "", ""))
    val detailsShopData: StateFlow<DetailsShopData> get() = _detailsShopData.asStateFlow()


    fun loadDetails() {
        _detailsData.tryEmit(getDetails())
    }

    fun loadDetailsShop() {
        _detailsShopData.tryEmit(getDetailsShop())
    }

}