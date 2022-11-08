package com.example.storeelectronicsproject.homestore.viewpager.viewmodel

import androidx.lifecycle.ViewModel
import com.example.storeelectronicsproject.homestore.viewpager.model.HotSalesData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HotSalesViewModel(
    private val getHotSales: HotSalesUseCase
) : ViewModel() {


    private var _hotSales: MutableStateFlow<HotSalesData> = MutableStateFlow(HotSalesData(1,"","","","",""))
    val hotSales: StateFlow<HotSalesData> get() = _hotSales.asStateFlow()

    fun loadHotSales() {
        _hotSales.tryEmit(getHotSales())
    }

}