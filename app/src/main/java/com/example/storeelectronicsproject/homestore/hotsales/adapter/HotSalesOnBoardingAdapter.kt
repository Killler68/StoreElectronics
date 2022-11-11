package com.example.storeelectronicsproject.homestore.hotsales.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.storeelectronicsproject.homestore.hotsales.FragmentHotSalesOnBoarding

class HotSalesOnBoardingAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {

    private val items = mutableListOf<Int>()

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun createFragment(position: Int): Fragment {
        return FragmentHotSalesOnBoarding.create(items[position])
    }

    fun setItems(item: List<Int>) {
        items.addAll(item)
    }
}