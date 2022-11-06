package com.example.storeelectronicsproject.homestore.viewmodel

import com.example.storeelectronicsproject.homestore.model.BestSellerData

interface BestSellerUseCase {

    operator fun invoke(): List<BestSellerData>
}