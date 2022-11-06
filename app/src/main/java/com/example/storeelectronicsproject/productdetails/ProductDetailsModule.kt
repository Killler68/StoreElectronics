package com.example.storeelectronicsproject.productdetails

import androidx.lifecycle.ViewModel
import com.example.storeelectronicsproject.productdetails.repository.DetailsRepositoryImpl
import com.example.storeelectronicsproject.productdetails.usecase.DetailsRepository
import com.example.storeelectronicsproject.productdetails.usecase.DetailsShopRepository
import com.example.storeelectronicsproject.productdetails.usecase.DetailsShopUseCaseImpl
import com.example.storeelectronicsproject.productdetails.usecase.DetailsUseCaseImpl
import com.example.storeelectronicsproject.productdetails.viewmodel.DetailsShopUseCase
import com.example.storeelectronicsproject.productdetails.viewmodel.DetailsUseCase
import com.example.storeelectronicsproject.productdetails.viewmodel.ProductDetailsViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class ProductDetailsModule {

    @Provides
    fun provideDetailsRepository(): DetailsRepository = DetailsRepositoryImpl()

    @Provides
    fun provideDetailsShopRepository(): DetailsShopRepository = DetailsRepositoryImpl()

    @Provides
    fun provideDetailsUseCase(repository: DetailsRepository): DetailsUseCase =
        DetailsUseCaseImpl(repository)

    @Provides
    fun provideDetailsShopUseCase(repository: DetailsShopRepository): DetailsShopUseCase =
        DetailsShopUseCaseImpl(repository)

    @Provides
    @IntoMap
    @ClassKey(ProductDetailsViewModel::class)
    fun provideProductDetailsViewModel(
        detailsUseCase: DetailsUseCase,
        shopUseCase: DetailsShopUseCase
    ): ViewModel {
        return ProductDetailsViewModel(detailsUseCase, shopUseCase)
    }
}