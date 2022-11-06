package com.example.storeelectronicsproject.productdetails.viewmodel

import com.example.storeelectronicsproject.productdetails.model.DetailsShopData

interface DetailsShopUseCase {

    operator fun invoke(): DetailsShopData

}