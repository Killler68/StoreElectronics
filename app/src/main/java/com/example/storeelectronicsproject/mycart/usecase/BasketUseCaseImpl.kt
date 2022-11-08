package com.example.storeelectronicsproject.mycart.usecase

import com.example.storeelectronicsproject.mycart.model.BasketData
import com.example.storeelectronicsproject.mycart.viewmodel.BasketUseCase
import io.reactivex.Single

class BasketUseCaseImpl(private val repository: BasketRepository) : BasketUseCase {

    override fun invoke(): Single<List<BasketData>> = repository.getBasket()

}