package com.example.storeelectronicsproject.homestore.viewpager.viewmodel

import com.example.storeelectronicsproject.homestore.viewpager.model.HotSalesData

interface HotSalesUseCase {

    operator fun invoke(): HotSalesData

}