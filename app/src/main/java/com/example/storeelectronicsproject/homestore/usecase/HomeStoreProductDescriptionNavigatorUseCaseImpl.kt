package com.example.storeelectronicsproject.homestore.usecase

import com.example.storeelectronicsproject.common.navigation.NavCommand
import com.example.storeelectronicsproject.homestore.viewmodel.HomeStoreProductDescriptionNavigatorUseCase

class HomeStoreProductDescriptionNavigatorUseCaseImpl(private val router: HomeStoreRouter) :
    HomeStoreProductDescriptionNavigatorUseCase {

    override fun invoke(): NavCommand = router.toProductDescription()

}