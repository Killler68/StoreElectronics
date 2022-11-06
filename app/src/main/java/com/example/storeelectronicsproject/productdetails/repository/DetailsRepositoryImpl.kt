package com.example.storeelectronicsproject.productdetails.repository

import com.example.storeelectronicsproject.productdetails.model.DetailsData
import com.example.storeelectronicsproject.productdetails.model.DetailsShopData
import com.example.storeelectronicsproject.productdetails.usecase.DetailsRepository
import com.example.storeelectronicsproject.productdetails.usecase.DetailsShopRepository

class DetailsRepositoryImpl : DetailsRepository, DetailsShopRepository {

    override fun getDetailsShop(): DetailsShopData = testDetailsShop
    override fun getDetails(): DetailsData = testDetails

}

private val testDetailsShop =
    DetailsShopData("Exynos 990", "108 + 12 mp", "8 GB", "256 GB")

private val testDetails =
    DetailsData("Galaxy Note 20 Ultra", 1, 8, 1500, 4.5)
