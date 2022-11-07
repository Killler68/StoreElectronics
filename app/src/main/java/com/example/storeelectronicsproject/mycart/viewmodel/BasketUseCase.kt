package com.example.storeelectronicsproject.mycart.viewmodel

import com.example.storeelectronicsproject.mycart.model.BasketData

interface BasketUseCase {

    operator fun invoke(): List<BasketData>

}