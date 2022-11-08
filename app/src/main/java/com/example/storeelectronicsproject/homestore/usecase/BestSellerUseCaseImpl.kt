package com.example.storeelectronicsproject.homestore.usecase

import com.example.storeelectronicsproject.homestore.model.BestSellerData
import com.example.storeelectronicsproject.homestore.viewmodel.BestSellerUseCase
import io.reactivex.Single

class BestSellerUseCaseImpl(private val repository: BestSellerRepository) : BestSellerUseCase {

    override fun invoke(): Single<List<BestSellerData>> = repository.getBestSeller()

}