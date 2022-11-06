package com.example.storeelectronicsproject.productdetails.usecase

import com.example.storeelectronicsproject.productdetails.model.DetailsData
import com.example.storeelectronicsproject.productdetails.viewmodel.DetailsUseCase

class DetailsUseCaseImpl(private val repository: DetailsRepository) : DetailsUseCase {

    override fun invoke(): DetailsData = repository.getDetails()

}