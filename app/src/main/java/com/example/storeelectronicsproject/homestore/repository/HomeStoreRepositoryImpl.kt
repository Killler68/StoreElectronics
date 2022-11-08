package com.example.storeelectronicsproject.homestore.repository

import com.example.storeelectronicsproject.common.api.StoreApi
import com.example.storeelectronicsproject.homestore.model.BestSellerData
import com.example.storeelectronicsproject.homestore.model.CategoryData
import com.example.storeelectronicsproject.homestore.model.HotSalesData
import com.example.storeelectronicsproject.homestore.usecase.BestSellerRepository
import com.example.storeelectronicsproject.homestore.usecase.CategoryRepository
import com.example.storeelectronicsproject.homestore.usecase.HotSalesRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeStoreRepositoryImpl(private val storeApi: StoreApi) :
    BestSellerRepository, CategoryRepository, HotSalesRepository {

    override fun getBestSeller(): Single<List<BestSellerData>> {
        try {
            val response = storeApi.getHomeStore()
            return response.map {
                it.best_seller.map {
                    BestSellerData(
                        it.discount_price,
                        it.id,
                        it.is_favorites,
                        it.picture,
                        it.price_without_discount,
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

    override fun getHotSales(): Single<List<HotSalesData>> {
        try {
            val response = storeApi.getHomeStore()
            return response.map {
                it.home_store.map {
                    HotSalesData(
                        it.id,
                        it.is_buy,
                        it.is_new,
                        it.picture,
                        it.subtitle,
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

    override fun getCategory(): List<CategoryData> = testCategory

}

private val testCategory = listOf(
    CategoryData("Phones"),
    CategoryData("Computers"),
    CategoryData("Health"),
    CategoryData("Books"),
)
