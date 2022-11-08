package com.example.storeelectronicsproject.mycart.usecase

import com.example.storeelectronicsproject.mycart.model.MyCartData
import io.reactivex.Single

interface MyCartRepository {

    fun getMyCart(): Single<MyCartData>
}