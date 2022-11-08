package com.example.storeelectronicsproject.productdetails.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.storeelectronicsproject.productdetails.FragmentDetailsOnBoarding

class DetailsOnBoardingAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return FragmentDetailsOnBoarding()
    }
}
