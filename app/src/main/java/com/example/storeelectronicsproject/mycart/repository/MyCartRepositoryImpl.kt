package com.example.storeelectronicsproject.mycart.repository

import com.example.storeelectronicsproject.common.api.StoreApi
import com.example.storeelectronicsproject.mycart.model.BasketData
import com.example.storeelectronicsproject.mycart.model.MyCartData
import com.example.storeelectronicsproject.mycart.usecase.BasketDeleteRepository
import com.example.storeelectronicsproject.mycart.usecase.BasketRepository
import com.example.storeelectronicsproject.mycart.usecase.MyCartRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MyCartRepositoryImpl(private val storeApi: StoreApi) :
    BasketRepository, MyCartRepository, BasketDeleteRepository {

    private val basket: MutableList<BasketData> = mutableListOf()

    override fun getBasket(): Single<List<BasketData>> {
        try {
            val response = storeApi.getMyCart()
            return response.map {
                it.basket.map {
                    BasketData(
                        it.id,
                        it.images,
                        it.price,
                        it.title
                    )
                }
            }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        } catch (e: Exception) {
            throw Exception()
        }
    }

    override fun getMyCart(): Single<MyCartData> {
        try {
            val response = storeApi.getMyCart()
            return response.map {
                MyCartData(
                    it.delivery,
                    it.id,
                    it.total
                )
            }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        } catch (e: Exception) {
            throw Exception()
        }
    }

    override fun deleteBasket(basketData: BasketData) {
        basket.remove(basketData)
    }
}