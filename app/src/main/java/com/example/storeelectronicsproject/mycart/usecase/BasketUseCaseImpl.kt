package com.example.storeelectronicsproject.mycart.usecase

import com.example.storeelectronicsproject.mycart.model.BasketData
import com.example.storeelectronicsproject.mycart.viewmodel.BasketUseCase

class BasketUseCaseImpl(private val repository: BasketRepository) : BasketUseCase {

    override fun invoke(): List<BasketData> = repository.getBasket()

}