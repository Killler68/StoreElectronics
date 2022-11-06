package com.example.storeelectronicsproject.homestore.usecase

import com.example.storeelectronicsproject.homestore.model.BestSellerData
import com.example.storeelectronicsproject.homestore.viewmodel.BestSellerUseCase

class BestSellerUseCaseImpl(private val repository: BestSellerRepository) : BestSellerUseCase {

    override fun invoke(): List<BestSellerData> = repository.getBestSeller()

}