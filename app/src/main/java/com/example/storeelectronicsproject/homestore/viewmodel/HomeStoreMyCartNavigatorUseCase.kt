package com.example.storeelectronicsproject.homestore.viewmodel

import com.example.storeelectronicsproject.common.navigation.NavCommand

interface HomeStoreMyCartNavigatorUseCase {

    operator fun invoke(): NavCommand

}