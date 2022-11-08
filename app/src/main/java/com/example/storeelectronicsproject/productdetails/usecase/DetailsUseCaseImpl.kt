package com.example.storeelectronicsproject.productdetails.usecase

import com.example.storeelectronicsproject.productdetails.model.DetailsData
import com.example.storeelectronicsproject.productdetails.viewmodel.DetailsUseCase
import io.reactivex.Single

class DetailsUseCaseImpl(private val repository: DetailsRepository) : DetailsUseCase {

    override fun invoke(): Single<DetailsData> = repository.getDetails()

}