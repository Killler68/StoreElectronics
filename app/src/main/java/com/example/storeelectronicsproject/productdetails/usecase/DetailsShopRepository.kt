package com.example.storeelectronicsproject.productdetails.usecase

import com.example.storeelectronicsproject.productdetails.model.DetailsShopData
import io.reactivex.Single

interface DetailsShopRepository {

    fun getDetailsShop(): Single<DetailsShopData>

}