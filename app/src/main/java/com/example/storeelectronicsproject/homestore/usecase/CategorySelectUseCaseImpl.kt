package com.example.storeelectronicsproject.homestore.usecase

import com.example.storeelectronicsproject.homestore.model.CategoryData
import com.example.storeelectronicsproject.homestore.viewmodel.CategorySelectUseCase

class CategorySelectUseCaseImpl(private val repository: CategoryRepository) :
    CategorySelectUseCase {

    override fun invoke(index: Int): List<CategoryData> {
        return repository.getCategory().mapIndexed { i, it ->
            it.isSelected = index == i
            it
        }
    }

}