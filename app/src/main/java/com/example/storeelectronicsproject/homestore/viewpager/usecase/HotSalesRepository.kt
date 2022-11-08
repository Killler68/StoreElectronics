package com.example.storeelectronicsproject.homestore.viewpager.usecase

import com.example.storeelectronicsproject.homestore.viewpager.model.HotSalesData

interface HotSalesRepository {

    fun getHotSales(): HotSalesData

}