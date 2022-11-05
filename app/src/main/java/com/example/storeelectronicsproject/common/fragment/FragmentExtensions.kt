package com.example.storeelectronicsproject.common.fragment

import androidx.fragment.app.Fragment
import com.example.storeelectronicsproject.R
import com.example.storeelectronicsproject.common.context.appComponent

fun Fragment.navigateToFragment(fragment: Fragment) {
    this.parentFragmentManager
        .beginTransaction()
        .replace(R.id.container, fragment, fragment.javaClass.simpleName)
        .addToBackStack(fragment.javaClass.simpleName)
        .commit()
}

fun Fragment.getViewModelFactory() =
    requireContext().applicationContext.appComponent.getViewModelFactory()