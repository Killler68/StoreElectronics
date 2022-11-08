package com.example.storeelectronicsproject.homestore.viewmodel

import com.example.storeelectronicsproject.common.navigation.NavCommand

interface HomeStoreProductDescriptionNavigatorUseCase {

    operator fun invoke(id: Int): NavCommand

}