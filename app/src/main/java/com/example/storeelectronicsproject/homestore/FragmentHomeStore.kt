package com.example.storeelectronicsproject.homestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.storeelectronicsproject.common.flow.launchWhenViewCreated
import com.example.storeelectronicsproject.common.fragment.getViewModelFactory
import com.example.storeelectronicsproject.common.fragment.navigateToFragment
import com.example.storeelectronicsproject.common.navigation.NavCommand
import com.example.storeelectronicsproject.databinding.FragmentHomeStoreBinding
import com.example.storeelectronicsproject.homestore.model.BestSellerData
import com.example.storeelectronicsproject.homestore.model.CategoryData
import com.example.storeelectronicsproject.homestore.viewholder.BestSellerItem
import com.example.storeelectronicsproject.homestore.viewholder.CategoryItem
import com.example.storeelectronicsproject.homestore.viewmodel.HomeStoreViewModel
import com.example.storeelectronicsproject.homestore.adapter.HotSalesOnBoardingAdapter
import com.example.storeelectronicsproject.mycart.FragmentMyCart
import com.example.storeelectronicsproject.productdetails.FragmentProductDetails
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil


class FragmentHomeStore : Fragment() {

    private var _binding: FragmentHomeStoreBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeStoreViewModel by viewModels { getViewModelFactory() }

    private val bestSellerItemAdapter = ItemAdapter<BestSellerItem>()
    private val fastAdapterBestSeller = GenericFastAdapter.with(listOf(bestSellerItemAdapter))

    private val categoryItemItemAdapter = ItemAdapter<CategoryItem>()
    private val fastAdapterCategory = GenericFastAdapter.with(listOf(categoryItemItemAdapter))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentHomeStoreBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createFastAdapter()
        setupObservables()
        setupListeners()
        setOnBoardingHotSalesItems()
        with(viewModel) {
            loadBestSeller()
            loadCategory()
        }
    }

    private fun setupObservables() {
        with(viewModel) {
            launchWhenViewCreated {
                data.observe(::onDataLoadedBestSeller)
                categoryData.observe(::onDataLoadedCategory)
                navCommand.observe(::onDataLoadedNavigation)
            }
        }
    }

    private fun onDataLoadedBestSeller(bestSellerData: List<BestSellerData>) {
        FastAdapterDiffUtil[bestSellerItemAdapter] = bestSellerData.map { BestSellerItem(it) }
    }

    private fun onDataLoadedCategory(categoryData: List<CategoryData>) {
        FastAdapterDiffUtil[categoryItemItemAdapter] = categoryData.map { CategoryItem(it) }
    }

    private fun onDataLoadedNavigation(navCommand: NavCommand) {
        findNavController().navigate(navCommand.action, navCommand.command)
    }

    private fun setupListeners() {
        binding.textNameCategoryHomeStore.setOnClickListener {
            viewModel.navigateToProductDescription()
        }
        binding.imageView10.setOnClickListener {
            viewModel.navigateToMyCart()
        }

    }

    private fun createFastAdapter() {
        with(binding.recyclerCategoryHomeStore) {
            adapter = fastAdapterCategory
            itemAnimator = null
        }
        with(binding.recyclerBestSellerHomeStore) {
            adapter = fastAdapterBestSeller
            itemAnimator = null
        }
    }

    private fun setOnBoardingHotSalesItems() {
        val hotSalesOnBoardingAdapter = HotSalesOnBoardingAdapter(this)
        binding.viewPagerHotSalesHomeStore.adapter = hotSalesOnBoardingAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}