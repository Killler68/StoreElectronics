package com.example.storeelectronicsproject.homestore.router

import com.example.storeelectronicsproject.R
import com.example.storeelectronicsproject.common.navigation.NavCommand
import com.example.storeelectronicsproject.homestore.usecase.HomeStoreRouter

class HomeStoreRouterImpl : HomeStoreRouter {

    override fun toProductDescription(): NavCommand =
        NavCommand(R.id.action_fragmentHomeStore_to_fragmentProductDetails)

    override fun toMyCart(): NavCommand =
        NavCommand(R.id.action_fragmentHomeStore_to_fragmentMyCart)
}
