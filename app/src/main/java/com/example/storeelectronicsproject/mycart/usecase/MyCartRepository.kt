package com.example.storeelectronicsproject.mycart.usecase

import com.example.storeelectronicsproject.mycart.model.MyCartData

interface MyCartRepository {

    fun getMyCart(): MyCartData
}