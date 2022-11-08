package com.example.storeelectronicsproject.productdetails.viewmodel

import com.example.storeelectronicsproject.productdetails.model.DetailsShopData
import io.reactivex.Single

interface DetailsShopUseCase {

    operator fun invoke(): Single<DetailsShopData>

}