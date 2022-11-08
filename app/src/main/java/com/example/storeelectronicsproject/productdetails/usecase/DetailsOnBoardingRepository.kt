package com.example.storeelectronicsproject.productdetails.usecase

import com.example.storeelectronicsproject.productdetails.model.DetailsOnBoardingData

interface DetailsOnBoardingRepository {

    fun getDetailsOnBoarding(): DetailsOnBoardingData
}