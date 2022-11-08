package com.example.storeelectronicsproject.homestore.hotsales.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.storeelectronicsproject.homestore.hotsales.FragmentHotSalesOnBoarding

class HotSalesOnBoardingAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return FragmentHotSalesOnBoarding()
    }
}