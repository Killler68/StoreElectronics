package com.example.storeelectronicsproject.homestore.repository

import com.example.storeelectronicsproject.homestore.model.BestSellerData
import com.example.storeelectronicsproject.homestore.model.CategoryData
import com.example.storeelectronicsproject.homestore.usecase.BestSellerRepository
import com.example.storeelectronicsproject.homestore.usecase.CategoryRepository

class HomeStoreRepositoryImpl : BestSellerRepository, CategoryRepository {

    override fun getBestSeller(): List<BestSellerData> = testBest

    override fun getCategory(): List<CategoryData> = testCategory


}

private val testBest = listOf(
    BestSellerData("Samsung galaxy s20 Ultra", 1000, 1500),
    BestSellerData("Samsung galaxy s10 Ultra", 800, 1200),
    BestSellerData("Nokia", 500, 1000),
    BestSellerData("Samsung galaxy s20 Ultra", 1000, 1500),
    BestSellerData("Samsung galaxy s20 Ultra", 1000, 1500),
)
private val testCategory = listOf(
    CategoryData("Phones"),
    CategoryData("Computers"),
    CategoryData("Health"),
    CategoryData("Books"),
)