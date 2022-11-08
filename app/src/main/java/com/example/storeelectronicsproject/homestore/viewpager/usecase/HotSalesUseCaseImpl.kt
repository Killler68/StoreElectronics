package com.example.storeelectronicsproject.homestore.viewpager.usecase

import com.example.storeelectronicsproject.homestore.viewpager.model.HotSalesData
import com.example.storeelectronicsproject.homestore.viewpager.viewmodel.HotSalesUseCase

class HotSalesUseCaseImpl(private val repository: HotSalesRepository) : HotSalesUseCase {

    override fun invoke(): HotSalesData = repository.getHotSales()

}