package com.example.storeelectronicsproject.homestore

import androidx.lifecycle.ViewModel
import com.example.storeelectronicsproject.homestore.repository.HomeStoreRepositoryImpl
import com.example.storeelectronicsproject.homestore.router.HomeStoreRouterImpl
import com.example.storeelectronicsproject.homestore.usecase.*
import com.example.storeelectronicsproject.homestore.viewmodel.*
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
    fun provideHomeStoreRouter(): HomeStoreRouter = HomeStoreRouterImpl()

    @Provides
    fun provideHomeStoreProductDescriptionNavigatorUseCase(router: HomeStoreRouter):
            HomeStoreProductDescriptionNavigatorUseCase =
        HomeStoreProductDescriptionNavigatorUseCaseImpl(router)

    @Provides
    fun provideHomeStoreMyCartNavigatorUseCase(router: HomeStoreRouter):
            HomeStoreMyCartNavigatorUseCase = HomeStoreMyCartNavigatorUseCaseImpl(router)

    @Provides
    @IntoMap
    @ClassKey(HomeStoreViewModel::class)
    fun provideHomeStoreViewModel(
        bestSellerUseCase: BestSellerUseCase,
        categoryUseCase: CategoryUseCase,
        hotSalesUseCase: HotSalesUseCase,
        navigatorDescriptionUseCase: HomeStoreProductDescriptionNavigatorUseCase,
        navigatorMyCartUseCase: HomeStoreMyCartNavigatorUseCase

    ): ViewModel {
        return HomeStoreViewModel(
            bestSellerUseCase,
            categoryUseCase,
            hotSalesUseCase,
            navigatorDescriptionUseCase,
            navigatorMyCartUseCase
        )
    }
}