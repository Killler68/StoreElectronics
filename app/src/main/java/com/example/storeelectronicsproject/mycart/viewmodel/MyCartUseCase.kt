package com.example.storeelectronicsproject.mycart.viewmodel

import com.example.storeelectronicsproject.mycart.model.MyCartData

interface MyCartUseCase {

    operator fun invoke(): MyCartData

}