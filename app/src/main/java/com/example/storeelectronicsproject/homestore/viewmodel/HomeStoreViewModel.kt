package com.example.storeelectronicsproject.homestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coinproject.common.rx.plusAssign
import com.example.storeelectronicsproject.common.flow.createSharedFlow
import com.example.storeelectronicsproject.common.navigation.NavCommand
import com.example.storeelectronicsproject.homestore.model.BestSellerData
import com.example.storeelectronicsproject.homestore.model.CategoryData
import com.example.storeelectronicsproject.homestore.model.HotSalesData
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.flow.*

class HomeStoreViewModel(
    private val getBestSeller: BestSellerUseCase,
    private val getCategory: CategoryUseCase,
    private val getCategorySelect: CategorySelectUseCase,
    private val getHotSales: HotSalesUseCase,
    private val getHotSale: HotSaleUseCase,
    private val navigatorDescription: HomeStoreProductDescriptionNavigatorUseCase,
    private val navigatorMyCart: HomeStoreMyCartNavigatorUseCase
) : ViewModel() {

    private var _data: MutableStateFlow<List<BestSellerData>> = MutableStateFlow(emptyList())
    val data: StateFlow<List<BestSellerData>> get() = _data.asStateFlow()

    private var _categoryData: MutableStateFlow<List<CategoryData>> = MutableStateFlow(emptyList())
    val categoryData: StateFlow<List<CategoryData>> get() = _categoryData.asStateFlow()

    private var _hotSales: MutableStateFlow<List<HotSalesData>> = MutableStateFlow(emptyList())
    val hotSales: StateFlow<List<HotSalesData>> get() = _hotSales.asStateFlow()

    private var _hotSale: MutableStateFlow<HotSalesData> =
        MutableStateFlow(HotSalesData(0, false, true, "", "", ""))
    val hotSale: StateFlow<HotSalesData> get() = _hotSale.asStateFlow()

    private val _navCommand: MutableSharedFlow<NavCommand> = createSharedFlow()
    val navCommand: SharedFlow<NavCommand> get() = _navCommand.asSharedFlow()

    private var _screenState: MutableLiveData<String> = MutableLiveData()
    val screenState: LiveData<String> get() = _screenState

    private var compositeDisposable = CompositeDisposable()


    fun loadBestSeller() {
        compositeDisposable += getBestSeller()
            .subscribe({
                _data.tryEmit(it)
            }, {
                _screenState.postValue(it.toString())
            })

    }

    fun loadCategory() {
        _categoryData.tryEmit(getCategory())
    }

    fun loadCategorySelect(index: Int) {
        _categoryData.tryEmit(getCategorySelect(index))
    }

    fun loadHotSales() {
        compositeDisposable += getHotSales()
            .subscribe({
                _hotSales.tryEmit(it)
            }, {
                _screenState.postValue(it.toString())
            })
    }

    fun loadHotSale(id: Int) {
        compositeDisposable += getHotSale(id)
            .subscribe({
                _hotSale.tryEmit(it)
            }, {
                _screenState.postValue(it.toString())
            })

    }

    fun navigateToProductDescription(id: Int) {
        _navCommand.tryEmit(navigatorDescription(id))
    }

    fun navigateToMyCart() {
        _navCommand.tryEmit(navigatorMyCart())
    }

}