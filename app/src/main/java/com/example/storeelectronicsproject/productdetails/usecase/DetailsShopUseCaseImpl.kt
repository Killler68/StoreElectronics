package com.example.storeelectronicsproject.productdetails.usecase

import com.example.storeelectronicsproject.productdetails.model.DetailsShopData
import com.example.storeelectronicsproject.productdetails.viewmodel.DetailsShopUseCase

class DetailsShopUseCaseImpl(private val repository: DetailsShopRepository) : DetailsShopUseCase {

    override fun invoke(): DetailsShopData = repository.getDetailsShop()

}