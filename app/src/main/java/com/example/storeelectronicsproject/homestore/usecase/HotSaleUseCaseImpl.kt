package com.example.storeelectronicsproject.homestore.usecase

import com.example.storeelectronicsproject.homestore.model.HotSalesData
import com.example.storeelectronicsproject.homestore.viewmodel.HotSaleUseCase
import io.reactivex.Single

class HotSaleUseCaseImpl(private val repository: HotSalesRepository) : HotSaleUseCase {

    override fun invoke(id: Int): Single<HotSalesData> = repository.getHotSaleById(id)

}