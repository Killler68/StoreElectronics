package com.example.storeelectronicsproject.mycart.viewmodel

import com.example.storeelectronicsproject.mycart.model.MyCartData
import io.reactivex.Single

interface MyCartUseCase {

    operator fun invoke(): Single<MyCartData>

}