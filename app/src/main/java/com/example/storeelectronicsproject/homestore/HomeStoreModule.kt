package com.example.storeelectronicsproject.homestore

import androidx.lifecycle.ViewModel
import com.example.storeelectronicsproject.homestore.viewmodel.HomeStoreViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class HomeStoreModule {

    @Provides
    @IntoMap
    @ClassKey(HomeStoreViewModel::class)
    fun provideHomeStoreViewModel(): ViewModel {
        return HomeStoreViewModel()
    }
}