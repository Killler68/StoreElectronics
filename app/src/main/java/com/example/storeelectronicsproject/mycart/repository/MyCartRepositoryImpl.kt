package com.example.storeelectronicsproject.mycart.repository

import com.example.storeelectronicsproject.mycart.model.BasketData
import com.example.storeelectronicsproject.mycart.model.MyCartData
import com.example.storeelectronicsproject.mycart.usecase.BasketRepository
import com.example.storeelectronicsproject.mycart.usecase.MyCartRepository

class MyCartRepositoryImpl : BasketRepository, MyCartRepository {

    override fun getBasket(): List<BasketData> = testBasket
    override fun getMyCart(): MyCartData = testMyCart

}

private val testBasket = listOf(
    BasketData(1, "1", 1000, "Galaxy Note"),
    BasketData(2, "2", 2000, "Galaxy "),
    BasketData(3, "3", 3000, "Samsung Note"),
    BasketData(4, "4", 4000, "Galaxy Note"),
    BasketData(5, "5", 5000, "Galaxy Note"),
    BasketData(6, "6", 6000, "Galaxy Note"),
)

private val testMyCart = MyCartData(1, "Free", 3300)