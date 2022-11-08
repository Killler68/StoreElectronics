package com.example.storeelectronicsproject.mycart.router

import com.example.storeelectronicsproject.R
import com.example.storeelectronicsproject.common.navigation.NavCommand
import com.example.storeelectronicsproject.mycart.usecase.MyCartRouter

class MyCartRouterImpl : MyCartRouter {

    override fun toHomeStore(): NavCommand =
        NavCommand(R.id.action_fragmentMyCart_to_fragmentHomeStore2)

}