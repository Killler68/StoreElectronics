package com.example.storeelectronicsproject.productdetails.viewmodel

import com.example.storeelectronicsproject.productdetails.model.DetailsImagesData
import io.reactivex.Single

interface DetailsImagesUseCase {

    operator fun invoke(): Single<DetailsImagesData>

}