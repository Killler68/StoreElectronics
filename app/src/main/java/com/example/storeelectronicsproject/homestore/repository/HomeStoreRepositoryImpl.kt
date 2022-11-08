package com.example.storeelectronicsproject.homestore.repository

import com.example.storeelectronicsproject.homestore.model.BestSellerData
import com.example.storeelectronicsproject.homestore.model.CategoryData
import com.example.storeelectronicsproject.homestore.model.HotSalesData
import com.example.storeelectronicsproject.homestore.usecase.BestSellerRepository
import com.example.storeelectronicsproject.homestore.usecase.CategoryRepository
import com.example.storeelectronicsproject.homestore.usecase.HotSalesRepository

class HomeStoreRepositoryImpl : BestSellerRepository, CategoryRepository, HotSalesRepository {

    override fun getBestSeller(): List<BestSellerData> = testBest
    override fun getCategory(): List<CategoryData> = testCategory
    override fun getHotSales(): HotSalesData = testHotSales

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
private val testHotSales =
    HotSalesData(1, "true", "Phone 1", "Cool Phone 1", "1", "true")