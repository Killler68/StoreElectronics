package com.example.storeelectronicsproject.homestore.usecase

import com.example.storeelectronicsproject.common.navigation.NavCommand
import com.example.storeelectronicsproject.homestore.viewmodel.HomeStoreMyCartNavigatorUseCase

class HomeStoreMyCartNavigatorUseCaseImpl(private val router: HomeStoreRouter) :
    HomeStoreMyCartNavigatorUseCase {

    override fun invoke(): NavCommand = router.toMyCart()

}