package com.example.storeelectronicsproject.homestore.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.storeelectronicsproject.homestore.FragmentHotSales

class HotSalesOnBoardingAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return FragmentHotSales()
    }
}