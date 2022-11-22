package com.example.storeelectronicsproject.productdetails.repository

import com.example.storeelectronicsproject.common.api.StoreApi
import com.example.storeelectronicsproject.productdetails.model.DetailsData
import com.example.storeelectronicsproject.productdetails.model.DetailsImagesData
import com.example.storeelectronicsproject.productdetails.model.DetailsShopData
import com.example.storeelectronicsproject.productdetails.usecase.DetailsImagesRepository
import com.example.storeelectronicsproject.productdetails.usecase.DetailsRepository
import com.example.storeelectronicsproject.productdetails.usecase.DetailsShopRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailsRepositoryImpl(private val storeApi: StoreApi) :
    DetailsRepository, DetailsShopRepository, DetailsImagesRepository {

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

    override fun getDetailsImages(): Single<DetailsImagesData> {
        try {
            val response = storeApi.getProductDetails()
            return response.map {
                DetailsImagesData(
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
