package com.example.storeelectronicsproject.homestore.usecase

import com.example.storeelectronicsproject.homestore.model.BestSellerData

interface BestSellerRepository {

    fun getBestSeller(): List<BestSellerData>

}