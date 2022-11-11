package com.example.storeelectronicsproject.homestore.model

import androidx.annotation.DrawableRes

data class CategoryData(
    @DrawableRes val image: Int,
    val name: String,
    var isSelected: Boolean = false
)
