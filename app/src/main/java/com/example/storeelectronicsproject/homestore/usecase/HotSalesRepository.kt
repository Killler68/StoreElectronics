package com.example.storeelectronicsproject.homestore.usecase

import com.example.storeelectronicsproject.homestore.model.HotSalesData
import io.reactivex.Single

interface HotSalesRepository {

    fun getHotSales(): Single<List<HotSalesData>>

}