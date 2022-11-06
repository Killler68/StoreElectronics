package com.example.storeelectronicsproject.homestore.viewmodel

import com.example.storeelectronicsproject.homestore.model.CategoryData

interface CategoryUseCase {

    operator fun invoke(): List<CategoryData>

}