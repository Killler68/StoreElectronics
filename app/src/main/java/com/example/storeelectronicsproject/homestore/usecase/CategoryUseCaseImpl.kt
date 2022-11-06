package com.example.storeelectronicsproject.homestore.usecase

import com.example.storeelectronicsproject.homestore.model.CategoryData
import com.example.storeelectronicsproject.homestore.viewmodel.CategoryUseCase

class CategoryUseCaseImpl(private val repository: CategoryRepository) : CategoryUseCase {

    override fun invoke(): List<CategoryData> = repository.getCategory()

}