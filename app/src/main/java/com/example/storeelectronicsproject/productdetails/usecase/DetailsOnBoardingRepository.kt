package com.example.storeelectronicsproject.productdetails.usecase

import com.example.storeelectronicsproject.productdetails.model.DetailsOnBoardingData
import io.reactivex.Single

interface DetailsOnBoardingRepository {

    fun getDetailsOnBoarding(): Single<DetailsOnBoardingData>
}