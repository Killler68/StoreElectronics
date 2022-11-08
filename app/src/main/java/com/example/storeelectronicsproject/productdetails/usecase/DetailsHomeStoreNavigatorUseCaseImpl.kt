package com.example.storeelectronicsproject.productdetails.usecase

import com.example.storeelectronicsproject.common.navigation.NavCommand
import com.example.storeelectronicsproject.productdetails.viewmodel.DetailsHomeStoreNavigatorUseCase

class DetailsHomeStoreNavigatorUseCaseImpl(private val router: DetailsRouter) :
    DetailsHomeStoreNavigatorUseCase {

    override fun invoke(): NavCommand = router.toHomeStore()

}