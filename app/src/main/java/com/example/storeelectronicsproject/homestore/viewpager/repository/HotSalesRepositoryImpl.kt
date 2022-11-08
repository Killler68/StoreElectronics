package com.example.storeelectronicsproject.homestore.viewpager.repository

import com.example.storeelectronicsproject.homestore.viewpager.model.HotSalesData
import com.example.storeelectronicsproject.homestore.viewpager.usecase.HotSalesRepository

class HotSalesRepositoryImpl : HotSalesRepository {

    override fun getHotSales(): HotSalesData = testHotSales

}


private val testHotSales =
    HotSalesData(1, "true", "Phone 1", "Cool Phone 1", "1", "true")
