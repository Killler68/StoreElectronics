package com.example.storeelectronicsproject.homestore.viewpager

import androidx.lifecycle.ViewModel
import com.example.storeelectronicsproject.homestore.viewpager.repository.HotSalesRepositoryImpl
import com.example.storeelectronicsproject.homestore.viewpager.usecase.HotSalesRepository
import com.example.storeelectronicsproject.homestore.viewpager.usecase.HotSalesUseCaseImpl
import com.example.storeelectronicsproject.homestore.viewpager.viewmodel.HotSalesUseCase
import com.example.storeelectronicsproject.homestore.viewpager.viewmodel.HotSalesViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class HotSalesModule {

    @Provides
    fun provideHotSalesRepository(): HotSalesRepository = HotSalesRepositoryImpl()

    @Provides
    fun provideHotSalesUseCase(repository: HotSalesRepository): HotSalesUseCase =
        HotSalesUseCaseImpl(repository)

    @Provides
    @IntoMap
    @ClassKey(HotSalesViewModel::class)
    fun provideHotSalesViewModel(
        hotSalesUseCase: HotSalesUseCase
    ): ViewModel {
        return HotSalesViewModel(hotSalesUseCase)
    }
}