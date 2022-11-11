package com.example.storeelectronicsproject.homestore.viewmodel

import com.example.storeelectronicsproject.homestore.model.CategoryData

interface CategorySelectUseCase {

    operator fun invoke(index: Int): List<CategoryData>

}