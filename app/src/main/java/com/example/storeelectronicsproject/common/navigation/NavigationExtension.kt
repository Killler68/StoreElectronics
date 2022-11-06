package com.example.storeelectronicsproject.common.navigation

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

@Deprecated(replaceWith = ReplaceWith("Router"), message = "Remove after replace all to routers")
fun Fragment.navigate(@IdRes action: Int) {
    findNavController().navigate(action)
}