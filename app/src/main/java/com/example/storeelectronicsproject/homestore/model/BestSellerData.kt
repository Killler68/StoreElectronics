package com.example.storeelectronicsproject.homestore.model

data class BestSellerData(
    val discount_price: Int,
    val id: Int,
    val is_favorites: Boolean,
    val picture: String,
    val price_without_discount: Int,
    val title: String
)
