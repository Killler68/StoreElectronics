package com.example.storeelectronicsproject.productdetails.usecase

import com.example.storeelectronicsproject.productdetails.model.DetailsData
import io.reactivex.Single

interface DetailsRepository {

    fun getDetails(): Single<DetailsData>

}