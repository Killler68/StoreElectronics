package com.example.storeelectronicsproject.homestore.usecase

import com.example.storeelectronicsproject.common.navigation.NavCommand

interface HomeStoreRouter {

    fun toProductDescription(id: Int): NavCommand
    fun toMyCart(): NavCommand
}