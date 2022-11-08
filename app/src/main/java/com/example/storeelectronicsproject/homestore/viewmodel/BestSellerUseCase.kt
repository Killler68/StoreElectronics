package com.example.storeelectronicsproject.homestore.viewmodel

import com.example.storeelectronicsproject.homestore.model.BestSellerData
import io.reactivex.Single

interface BestSellerUseCase {

    operator fun invoke(): Single<List<BestSellerData>>
}