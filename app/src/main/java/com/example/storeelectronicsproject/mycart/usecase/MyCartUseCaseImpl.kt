package com.example.storeelectronicsproject.mycart.usecase

import com.example.storeelectronicsproject.mycart.model.MyCartData
import com.example.storeelectronicsproject.mycart.viewmodel.MyCartUseCase

class MyCartUseCaseImpl(private val repository: MyCartRepository) : MyCartUseCase {

    override fun invoke(): MyCartData = repository.getMyCart()

}