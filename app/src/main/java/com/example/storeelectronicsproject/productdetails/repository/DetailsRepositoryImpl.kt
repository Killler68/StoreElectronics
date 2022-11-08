package com.example.storeelectronicsproject.productdetails.repository

import com.example.storeelectronicsproject.common.api.StoreApi
import com.example.storeelectronicsproject.productdetails.model.DetailsData
import com.example.storeelectronicsproject.productdetails.model.DetailsOnBoardingData
import com.example.storeelectronicsproject.productdetails.model.DetailsShopData
import com.example.storeelectronicsproject.productdetails.usecase.DetailsOnBoardingRepository
import com.example.storeelectronicsproject.productdetails.usecase.DetailsRepository
import com.example.storeelectronicsproject.productdetails.usecase.DetailsShopRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailsRepositoryImpl(private val storeApi: StoreApi) :
    DetailsRepository, DetailsShopRepository, DetailsOnBoardingRepository {

    override fun getDetailsShop(): Single<DetailsShopData> {
        try {
            val response = storeApi.getProductDetails()
            return response.map {
                DetailsShopData(
                    it.CPU,
                    it.camera,
                    it.ssd,
                    it.sd
                )
            }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        } catch (e: Exception) {
            throw Exception()
        }

    }

    override fun getDetails(): Single<DetailsData> {
        try {
            val response = storeApi.getProductDetails()
            return response.map {
                DetailsData(
                    it.id,
                    it.title,
                    it.color,
                    it.capacity,
                    it.price,
                    it.rating
                )
            }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        } catch (e: Exception) {
            throw Exception()
        }
    }

    override fun getDetailsOnBoarding(): Single<DetailsOnBoardingData> {
        try {
            val response = storeApi.getProductDetails()
            return response.map {
                DetailsOnBoardingData(
                    it.id,
                    it.images
                )
            }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        } catch (e: Exception) {
            throw Exception()
        }
    }
}
