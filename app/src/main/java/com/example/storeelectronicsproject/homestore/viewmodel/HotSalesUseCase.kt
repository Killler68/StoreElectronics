package com.example.storeelectronicsproject.homestore.viewmodel

import com.example.storeelectronicsproject.homestore.model.HotSalesData
import io.reactivex.Single

interface HotSalesUseCase {

    operator fun invoke(): Single<List<HotSalesData>>

}