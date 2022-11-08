package com.example.storeelectronicsproject.productdetails.router

import com.example.storeelectronicsproject.R
import com.example.storeelectronicsproject.common.navigation.NavCommand
import com.example.storeelectronicsproject.productdetails.usecase.DetailsRouter

class ProductDetailsRouterImpl : DetailsRouter {

    override fun toHomeStore(): NavCommand =
        NavCommand(R.id.action_fragmentProductDetails_to_fragmentHomeStore)

}