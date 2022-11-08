package com.example.storeelectronicsproject.productdetails.usecase

import com.example.storeelectronicsproject.productdetails.model.DetailsShopData
import com.example.storeelectronicsproject.productdetails.viewmodel.DetailsShopUseCase
import io.reactivex.Single

class DetailsShopUseCaseImpl(private val repository: DetailsShopRepository) : DetailsShopUseCase {

    override fun invoke(): Single<DetailsShopData> = repository.getDetailsShop()

}