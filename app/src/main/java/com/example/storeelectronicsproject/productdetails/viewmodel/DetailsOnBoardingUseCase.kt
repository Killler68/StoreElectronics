package com.example.storeelectronicsproject.productdetails.viewmodel

import com.example.storeelectronicsproject.productdetails.model.DetailsOnBoardingData
import io.reactivex.Single

interface DetailsOnBoardingUseCase {

    operator fun invoke(): Single<DetailsOnBoardingData>

}