package com.example.storeelectronicsproject.homestore.viewpager.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.storeelectronicsproject.homestore.viewpager.FragmentHotSales
import com.example.storeelectronicsproject.homestore.viewpager.model.HotSalesData
import com.example.storeelectronicsproject.homestore.viewpager.repository.HotSalesRepositoryImpl
import com.example.storeelectronicsproject.homestore.viewpager.usecase.HotSalesRepository
import com.example.storeelectronicsproject.mycart.FragmentMyCart

class OnBoardingHotSalesAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return FragmentHotSales()
    }
}