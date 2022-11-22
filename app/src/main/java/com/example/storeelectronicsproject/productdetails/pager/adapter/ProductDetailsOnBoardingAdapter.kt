package com.example.storeelectronicsproject.productdetails.pager.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.storeelectronicsproject.productdetails.pager.FragmentProductDetailsOnBoarding

class ProductDetailsOnBoardingAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val items = mutableListOf<String>()

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun createFragment(position: Int): Fragment {
        return FragmentProductDetailsOnBoarding.create(items[position])
    }

    fun setItems(item: String) {
        items.addAll(listOf(item))
    }
}