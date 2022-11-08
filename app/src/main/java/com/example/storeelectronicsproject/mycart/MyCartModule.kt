package com.example.storeelectronicsproject.mycart

import androidx.lifecycle.ViewModel
import com.example.storeelectronicsproject.mycart.repository.MyCartRepositoryImpl
import com.example.storeelectronicsproject.mycart.router.MyCartRouterImpl
import com.example.storeelectronicsproject.mycart.usecase.*
import com.example.storeelectronicsproject.mycart.viewmodel.BasketUseCase
import com.example.storeelectronicsproject.mycart.viewmodel.MyCartHomeStoreNavigatorUseCase
import com.example.storeelectronicsproject.mycart.viewmodel.MyCartUseCase
import com.example.storeelectronicsproject.mycart.viewmodel.MyCartViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class MyCartModule {

    @Provides
    fun provideBasketRepository(): BasketRepository = MyCartRepositoryImpl()

    @Provides
    fun provideMyCartRepository(): MyCartRepository = MyCartRepositoryImpl()

    @Provides
    fun provideBasketUseCase(repository: BasketRepository): BasketUseCase =
        BasketUseCaseImpl(repository)

    @Provides
    fun provideMyCartUseCase(repository: MyCartRepository): MyCartUseCase =
        MyCartUseCaseImpl(repository)

    @Provides
    fun provideMyCartRouter(): MyCartRouter = MyCartRouterImpl()

    @Provides
    fun provideMyCartHomeStoreNavigatorUseCase(router: MyCartRouter): MyCartHomeStoreNavigatorUseCase =
        MyCartHomeStoreNavigatorUseCaseImpl(router)

    @Provides
    @IntoMap
    @ClassKey(MyCartViewModel::class)
    fun provideMyCartViewModel(
        basketUseCase: BasketUseCase,
        myCartUseCase: MyCartUseCase,
        navigatorHomeStoreUseCase: MyCartHomeStoreNavigatorUseCase
    ): ViewModel {
        return MyCartViewModel(basketUseCase, myCartUseCase, navigatorHomeStoreUseCase)
    }
}