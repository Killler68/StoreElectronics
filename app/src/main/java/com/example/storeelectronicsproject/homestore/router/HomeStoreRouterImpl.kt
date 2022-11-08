package com.example.storeelectronicsproject.homestore.router

import androidx.core.os.bundleOf
import com.example.storeelectronicsproject.R
import com.example.storeelectronicsproject.common.navigation.NavCommand
import com.example.storeelectronicsproject.homestore.usecase.HomeStoreRouter
import com.example.storeelectronicsproject.productdetails.KEY

class HomeStoreRouterImpl : HomeStoreRouter {

    override fun toProductDescription(id: Int): NavCommand =
        NavCommand(R.id.action_fragmentHomeStore_to_fragmentProductDetails, bundleOf(KEY to id))

    override fun toMyCart(): NavCommand =
        NavCommand(R.id.action_fragmentHomeStore_to_fragmentMyCart)
}
