package com.example.storeelectronicsproject.productdetails.model

data class DetailsData(
    val id: String,
    val title: String,
    val color: List<String>,
    val capacity: List<String>,
    val price: Int,
    val rating: Double
)
