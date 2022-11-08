package com.example.storeelectronicsproject.productdetails.usecase

import com.example.storeelectronicsproject.productdetails.model.DetailsOnBoardingData
import com.example.storeelectronicsproject.productdetails.viewmodel.DetailsOnBoardingUseCase
import io.reactivex.Single

class DetailsOnBoardingUseCaseImpl(private val repository: DetailsOnBoardingRepository) :
    DetailsOnBoardingUseCase {

    override fun invoke(): Single<DetailsOnBoardingData> = repository.getDetailsOnBoarding()

}