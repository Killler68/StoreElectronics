package com.example.storeelectronicsproject.homestore.usecase

import com.example.storeelectronicsproject.homestore.model.CategoryData

interface CategoryRepository {

    fun getCategory(): List<CategoryData>

}