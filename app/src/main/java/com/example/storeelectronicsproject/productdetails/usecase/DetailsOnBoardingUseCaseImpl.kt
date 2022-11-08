package com.example.storeelectronicsproject.productdetails.usecase

import com.example.storeelectronicsproject.productdetails.model.DetailsOnBoardingData
import com.example.storeelectronicsproject.productdetails.viewmodel.DetailsOnBoardingUseCase

class DetailsOnBoardingUseCaseImpl(private val repository: DetailsOnBoardingRepository) :
    DetailsOnBoardingUseCase {

    override fun invoke(): DetailsOnBoardingData = repository.getDetailsOnBoarding()

}