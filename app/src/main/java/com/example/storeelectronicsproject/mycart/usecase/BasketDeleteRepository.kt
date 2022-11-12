package com.example.storeelectronicsproject.mycart.usecase

import com.example.storeelectronicsproject.mycart.model.BasketData

interface BasketDeleteRepository {

    fun deleteBasket(basketData: BasketData)
}