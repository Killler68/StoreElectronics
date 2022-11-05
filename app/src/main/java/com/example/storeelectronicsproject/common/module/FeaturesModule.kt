package com.example.storeelectronicsproject.common.module

import com.example.storeelectronicsproject.common.application.ApplicationModule
import com.example.storeelectronicsproject.homestore.HomeStoreModule
import dagger.Module

@Module(
    includes = [
        ApplicationModule::class,
        HomeStoreModule::class
    ]
)
class FeaturesModule
