package com.example.storeelectronicsproject.homestore.usecase

import com.example.storeelectronicsproject.homestore.model.HotSalesData
import com.example.storeelectronicsproject.homestore.viewmodel.HotSalesUseCase
import io.reactivex.Single

class HotSalesUseCaseImpl(private val repository: HotSalesRepository) : HotSalesUseCase {

    override fun invoke(): Single<List<HotSalesData>> = repository.getHotSales()

}