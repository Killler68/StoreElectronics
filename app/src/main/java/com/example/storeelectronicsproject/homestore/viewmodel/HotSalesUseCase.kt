package com.example.storeelectronicsproject.homestore.viewmodel

import com.example.storeelectronicsproject.homestore.model.HotSalesData

interface HotSalesUseCase {

    operator fun invoke(): HotSalesData

}