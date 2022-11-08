package com.example.storeelectronicsproject.homestore.usecase

import com.example.storeelectronicsproject.common.navigation.NavCommand

interface HomeStoreRouter {

    fun toProductDescription(): NavCommand
    fun toMyCart(): NavCommand
}