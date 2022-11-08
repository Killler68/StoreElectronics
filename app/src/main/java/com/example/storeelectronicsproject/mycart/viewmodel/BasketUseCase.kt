package com.example.storeelectronicsproject.mycart.viewmodel

import com.example.storeelectronicsproject.mycart.model.BasketData
import io.reactivex.Single

interface BasketUseCase {

    operator fun invoke(): Single<List<BasketData>>

}