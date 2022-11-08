package com.example.storeelectronicsproject.productdetails.viewmodel

import com.example.storeelectronicsproject.productdetails.model.DetailsData
import io.reactivex.Single

interface DetailsUseCase {

    operator fun invoke(): Single<DetailsData>

}