package com.example.storeelectronicsproject.homestore

import androidx.lifecycle.ViewModel
import com.example.storeelectronicsproject.homestore.repository.HomeStoreRepositoryImpl
import com.example.storeelectronicsproject.homestore.usecase.*
import com.example.storeelectronicsproject.homestore.viewmodel.BestSellerUseCase
import com.example.storeelectronicsproject.homestore.viewmodel.CategoryUseCase
import com.example.storeelectronicsproject.homestore.viewmodel.HomeStoreViewModel
import com.example.storeelectronicsproject.homestore.viewmodel.HotSalesUseCase
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class HomeStoreModule {

    @Provides
    fun provideBestSellerRepository(): BestSellerRepository = HomeStoreRepositoryImpl()

    @Provides
    fun provideCategoryRepository(): CategoryRepository = HomeStoreRepositoryImpl()

    @Provides
    fun provideHotSalesRepository(): HotSalesRepository = HomeStoreRepositoryImpl()

    @Provides
    fun provideBestSellerUseCase(repository: BestSellerRepository): BestSellerUseCase =
        BestSellerUseCaseImpl(repository)

    @Provides
    fun provideCategoryUseCase(repository: CategoryRepository): CategoryUseCase =
        CategoryUseCaseImpl(repository)

    @Provides
    fun provideHotSalesUseCase(repository: HotSalesRepository): HotSalesUseCase =
        HotSalesUseCaseImpl(repository)

    @Provides
    @IntoMap
    @ClassKey(HomeStoreViewModel::class)
    fun provideHomeStoreViewModel(
        bestSellerUseCase: BestSellerUseCase,
        categoryUseCase: CategoryUseCase,
        hotSalesUseCase: HotSalesUseCase

    ): ViewModel {
        return HomeStoreViewModel(bestSellerUseCase, categoryUseCase, hotSalesUseCase)
    }
}