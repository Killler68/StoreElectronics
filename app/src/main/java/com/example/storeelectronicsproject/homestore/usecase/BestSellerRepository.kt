package com.example.storeelectronicsproject.homestore.usecase

import com.example.storeelectronicsproject.homestore.model.BestSellerData
import io.reactivex.Single

interface BestSellerRepository {

    fun getBestSeller(): Single<List<BestSellerData>>

}