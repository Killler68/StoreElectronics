package com.example.storeelectronicsproject.mycart.usecase

import com.example.storeelectronicsproject.mycart.model.BasketData
import io.reactivex.Single

interface BasketRepository {

    fun getBasket(): Single<List<BasketData>>
}