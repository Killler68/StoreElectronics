package com.example.storeelectronicsproject.homestore.viewmodel

import androidx.lifecycle.ViewModel
import com.example.storeelectronicsproject.common.flow.createSharedFlow
import com.example.storeelectronicsproject.common.navigation.NavCommand
import com.example.storeelectronicsproject.homestore.model.BestSellerData
import com.example.storeelectronicsproject.homestore.model.CategoryData
import com.example.storeelectronicsproject.homestore.model.HotSalesData
import kotlinx.coroutines.flow.*

class HomeStoreViewModel(
    private val getBestSeller: BestSellerUseCase,
    private val getCategory: CategoryUseCase,
    private val getHotSales: HotSalesUseCase,
    private val navigatorDescription: HomeStoreProductDescriptionNavigatorUseCase,
    private val navigatorMyCart: HomeStoreMyCartNavigatorUseCase
) : ViewModel() {

    private var _data: MutableStateFlow<List<BestSellerData>> = MutableStateFlow(emptyList())
    val data: StateFlow<List<BestSellerData>> get() = _data.asStateFlow()

    private var _categoryData: MutableStateFlow<List<CategoryData>> = MutableStateFlow(emptyList())
    val categoryData: StateFlow<List<CategoryData>> get() = _categoryData.asStateFlow()

    private var _hotSales: MutableStateFlow<HotSalesData> =
        MutableStateFlow(HotSalesData(1, "", "", "", "", ""))
    val hotSales: StateFlow<HotSalesData> get() = _hotSales.asStateFlow()

    private val _navCommand: MutableSharedFlow<NavCommand> = createSharedFlow()
    val navCommand: SharedFlow<NavCommand> get() = _navCommand.asSharedFlow()

    fun loadBestSeller() {
        _data.tryEmit(getBestSeller())
    }

    fun loadCategory() {
        _categoryData.tryEmit(getCategory())
    }

    fun loadHotSales() {
        _hotSales.tryEmit(getHotSales())
    }

    fun navigateToProductDescription() {
        _navCommand.tryEmit(navigatorDescription())
    }

    fun navigateToMyCart() {
        _navCommand.tryEmit(navigatorMyCart())
    }

}