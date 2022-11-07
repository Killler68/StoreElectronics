package com.example.storeelectronicsproject.mycart.usecase

import com.example.storeelectronicsproject.mycart.model.BasketData

interface BasketRepository {

    fun getBasket(): List<BasketData>
}