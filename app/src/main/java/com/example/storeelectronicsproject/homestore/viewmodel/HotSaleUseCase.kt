package com.example.storeelectronicsproject.homestore.viewmodel

import com.example.storeelectronicsproject.homestore.model.HotSalesData
import io.reactivex.Single

interface HotSaleUseCase {

    operator fun invoke(id: Int): Single<HotSalesData>

}