package com.example.storeelectronicsproject.mycart.usecase

import com.example.storeelectronicsproject.common.navigation.NavCommand
import com.example.storeelectronicsproject.mycart.viewmodel.MyCartHomeStoreNavigatorUseCase

class MyCartHomeStoreNavigatorUseCaseImpl(private val router: MyCartRouter) :
    MyCartHomeStoreNavigatorUseCase {

    override fun invoke(): NavCommand = router.toHomeStore()

}