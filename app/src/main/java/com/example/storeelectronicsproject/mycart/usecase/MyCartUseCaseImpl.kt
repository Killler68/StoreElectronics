package com.example.storeelectronicsproject.mycart.usecase

import com.example.storeelectronicsproject.mycart.model.MyCartData
import com.example.storeelectronicsproject.mycart.viewmodel.MyCartUseCase
import io.reactivex.Single

class MyCartUseCaseImpl(private val repository: MyCartRepository) : MyCartUseCase {

    override fun invoke(): Single<MyCartData> = repository.getMyCart()

}