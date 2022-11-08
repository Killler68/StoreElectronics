package com.example.storeelectronicsproject.homestore.usecase

import com.example.storeelectronicsproject.homestore.model.HotSalesData

interface HotSalesRepository {

    fun getHotSales(): HotSalesData

}