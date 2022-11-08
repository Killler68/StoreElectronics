package com.example.storeelectronicsproject.productdetails

import androidx.lifecycle.ViewModel
import com.example.storeelectronicsproject.common.api.StoreApi
import com.example.storeelectronicsproject.productdetails.repository.DetailsRepositoryImpl
import com.example.storeelectronicsproject.productdetails.router.ProductDetailsRouterImpl
import com.example.storeelectronicsproject.productdetails.usecase.*
import com.example.storeelectronicsproject.productdetails.viewmodel.*
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class ProductDetailsModule {

    @Provides
    fun provideDetailsRepository(storeApi: StoreApi): DetailsRepository = DetailsRepositoryImpl(storeApi)

    @Provides
    fun provideDetailsShopRepository(storeApi: StoreApi): DetailsShopRepository = DetailsRepositoryImpl(storeApi)

    @Provides
    fun provideDetailsOnBoardingRepository(storeApi: StoreApi): DetailsOnBoardingRepository =
        DetailsRepositoryImpl(storeApi)

    @Provides
    fun provideDetailsUseCase(repository: DetailsRepository): DetailsUseCase =
        DetailsUseCaseImpl(repository)

    @Provides
    fun provideDetailsShopUseCase(repository: DetailsShopRepository): DetailsShopUseCase =
        DetailsShopUseCaseImpl(repository)

    @Provides
    fun provideDetailsOnBoardingUseCase(repository: DetailsOnBoardingRepository):
            DetailsOnBoardingUseCase = DetailsOnBoardingUseCaseImpl(repository)

    @Provides
    fun provideDetailsRouter(): DetailsRouter = ProductDetailsRouterImpl()

    @Provides
    fun provideDetailsHomeStoreNavigatorUseCase(router: DetailsRouter):
            DetailsHomeStoreNavigatorUseCase = DetailsHomeStoreNavigatorUseCaseImpl(router)

    @Provides
    @IntoMap
    @ClassKey(ProductDetailsViewModel::class)
    fun provideProductDetailsViewModel(
        detailsUseCase: DetailsUseCase,
        shopUseCase: DetailsShopUseCase,
        onBoardingUseCase: DetailsOnBoardingUseCase,
        navigatorHomeStoreUseCase: DetailsHomeStoreNavigatorUseCase
    ): ViewModel {
        return ProductDetailsViewModel(
            detailsUseCase,
            shopUseCase,
            onBoardingUseCase,
            navigatorHomeStoreUseCase
        )
    }
}