package com.example.storeelectronicsproject.productdetails.usecase

import com.example.storeelectronicsproject.productdetails.model.DetailsData

interface DetailsRepository {

    fun getDetails(): DetailsData

}