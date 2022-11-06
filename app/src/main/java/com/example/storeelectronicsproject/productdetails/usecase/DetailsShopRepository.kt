package com.example.storeelectronicsproject.productdetails.usecase

import com.example.storeelectronicsproject.productdetails.model.DetailsShopData

interface DetailsShopRepository {

    fun getDetailsShop(): DetailsShopData

}