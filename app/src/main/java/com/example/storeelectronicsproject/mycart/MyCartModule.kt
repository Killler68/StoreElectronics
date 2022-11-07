package com.example.storeelectronicsproject.mycart

import androidx.lifecycle.ViewModel
import com.example.storeelectronicsproject.mycart.repository.MyCartRepositoryImpl
import com.example.storeelectronicsproject.mycart.usecase.BasketRepository
import com.example.storeelectronicsproject.mycart.usecase.BasketUseCaseImpl
import com.example.storeelectronicsproject.mycart.usecase.MyCartRepository
import com.example.storeelectronicsproject.mycart.usecase.MyCartUseCaseImpl
import com.example.storeelectronicsproject.mycart.viewmodel.BasketUseCase
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
    @IntoMap
    @ClassKey(MyCartViewModel::class)
    fun provideMyCartViewModel(
        basketUseCase: BasketUseCase,
        myCartUseCase: MyCartUseCase
    ): ViewModel {
        return MyCartViewModel(basketUseCase, myCartUseCase)
    }
}