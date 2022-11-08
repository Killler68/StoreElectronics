package com.example.storeelectronicsproject.common.api

import com.example.storeelectronicsproject.homestore.model.DataResponse
import com.example.storeelectronicsproject.mycart.model.MyCartResponse
import com.example.storeelectronicsproject.productdetails.model.ProductDetailsResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://run.mocky.io"

interface StoreApi {

    @GET("/v3/654bd15e-b121-49ba-a588-960956b15175")
    fun getHomeStore(): Single<DataResponse>

    @GET("/v3/6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    fun getProductDetails(): Single<ProductDetailsResponse>

    @GET("/v3/53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    fun getMyCart(): Single<MyCartResponse>

    companion object {
        fun create(): StoreApi {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(StoreApi::class.java)
        }
    }

}