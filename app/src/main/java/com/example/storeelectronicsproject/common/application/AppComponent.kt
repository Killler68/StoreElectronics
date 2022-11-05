package com.example.storeelectronicsproject.common.application

import androidx.lifecycle.ViewModelProvider
import com.example.storeelectronicsproject.common.viewmodel.ViewModelModule
import com.example.storeelectronicsproject.common.module.FeaturesModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        FeaturesModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {
    fun getViewModelFactory(): ViewModelProvider.Factory
}