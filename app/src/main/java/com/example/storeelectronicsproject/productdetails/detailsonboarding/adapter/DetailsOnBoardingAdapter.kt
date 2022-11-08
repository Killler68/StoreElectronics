package com.example.storeelectronicsproject.productdetails.detailsonboarding.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.storeelectronicsproject.productdetails.detailsonboarding.FragmentDetailsOnBoarding

class DetailsOnBoardingAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return FragmentDetailsOnBoarding()
    }
}
