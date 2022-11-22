package com.example.storeelectronicsproject.productdetails.usecase

import com.example.storeelectronicsproject.productdetails.model.DetailsImagesData
import com.example.storeelectronicsproject.productdetails.viewmodel.DetailsImagesUseCase
import io.reactivex.Single

class DetailsImagesUseCaseImpl(private val repository: DetailsImagesRepository) :
    DetailsImagesUseCase {

    override fun invoke(): Single<DetailsImagesData> = repository.getDetailsImages()

}