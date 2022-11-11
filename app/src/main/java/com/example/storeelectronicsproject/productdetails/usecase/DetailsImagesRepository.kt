package com.example.storeelectronicsproject.productdetails.usecase

import com.example.storeelectronicsproject.productdetails.model.DetailsImagesData
import io.reactivex.Single

interface DetailsImagesRepository {

    fun getDetailsImages(): Single<List<DetailsImagesData>>
}