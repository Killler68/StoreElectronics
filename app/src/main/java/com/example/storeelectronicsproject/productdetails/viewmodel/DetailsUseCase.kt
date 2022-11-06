package com.example.storeelectronicsproject.productdetails.viewmodel

import com.example.storeelectronicsproject.productdetails.model.DetailsData

interface DetailsUseCase {

    operator fun invoke(): DetailsData

}