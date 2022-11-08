package com.example.storeelectronicsproject.common.module

import com.example.storeelectronicsproject.common.application.ApplicationModule
import com.example.storeelectronicsproject.homestore.HomeStoreModule
import com.example.storeelectronicsproject.mycart.MyCartModule
import com.example.storeelectronicsproject.productdetails.ProductDetailsModule
import dagger.Module

@Module(
    includes = [
        ApplicationModule::class,
        HomeStoreModule::class,
        ProductDetailsModule::class,
        MyCartModule::class
    ]
)
class FeaturesModule
