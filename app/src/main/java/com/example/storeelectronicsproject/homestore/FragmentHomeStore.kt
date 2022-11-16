package com.example.storeelectronicsproject.homestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.storeelectronicsproject.common.flow.launchWhenViewCreated
import com.example.storeelectronicsproject.common.fragment.getViewModelFactory
import com.example.storeelectronicsproject.common.navigation.NavCommand
import com.example.storeelectronicsproject.common.state.State
import com.example.storeelectronicsproject.databinding.FragmentHomeStoreBinding
import com.example.storeelectronicsproject.homestore.hotsales.adapter.HotSalesOnBoardingAdapter
import com.example.storeelectronicsproject.homestore.model.BestSellerData
import com.example.storeelectronicsproject.homestore.model.CategoryData
import com.example.storeelectronicsproject.homestore.model.HotSalesData
import com.example.storeelectronicsproject.homestore.viewholder.BestSellerItem
import com.example.storeelectronicsproject.homestore.viewholder.CategoryItem
import com.example.storeelectronicsproject.homestore.viewmodel.HomeStoreViewModel
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

        fastAdapterCategory.onClickListener = { _, _, item, position ->
            viewModel.loadCategorySelect(position)
            true
        }


        createFastAdapter()
        setupObservables()
        setupListeners()
        with(viewModel) {
            loadBestSeller()
            loadCategory()
            loadHotSales()
        }
    }

    private fun setupObservables() {
        with(viewModel) {
            launchWhenViewCreated {
                data.observe(::onDataLoadedBestSeller)
                categoryData.observe(::onDataLoadedCategory)
                navCommand.observe(::onDataLoadedNavigation)
                hotSales.observe(::setOnBoardingHotSalesItems)
                screenState.observe(viewLifecycleOwner, ::stateScreen)
            }
        }
    }

    private fun onDataLoadedBestSeller(bestSellerData: List<BestSellerData>) {
        FastAdapterDiffUtil[bestSellerItemAdapter] = bestSellerData.map {
            BestSellerItem(
                it,
                viewModel::navigateToProductDescription
            )
        }
    }

    private fun onDataLoadedCategory(categoryData: List<CategoryData>) {
        FastAdapterDiffUtil[categoryItemItemAdapter] = categoryData.map { CategoryItem(it) }
    }

    private fun onDataLoadedNavigation(navCommand: NavCommand) {
        findNavController().navigate(navCommand.action, navCommand.command)
    }

    private fun setupListeners() {
        binding.imageStore.setOnClickListener {
            viewModel.navigateToMyCart()
        }
        binding.imageFilterHomeStore.setOnClickListener {
            binding.containerFilterHomeStore.backgroundFilterOptions.isVisible =
                !binding.containerFilterHomeStore.backgroundFilterOptions.isVisible

            binding.recyclerBestSellerHomeStore.isVisible =
                !binding.recyclerBestSellerHomeStore.isVisible
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

    private fun setOnBoardingHotSalesItems(hotSalesData: List<HotSalesData>) {
        val hotSalesOnBoardingAdapter = HotSalesOnBoardingAdapter(this)
        hotSalesOnBoardingAdapter.setItems(hotSalesData.map { it.id })
        binding.viewPagerHotSalesHomeStore.adapter = hotSalesOnBoardingAdapter
    }

    private fun stateScreen(state: State) {
        when (state) {
            State.Loading -> onScreenLoading()
            State.Loaded -> onScreenLoaded()
            State.Error -> onScreenError()
        }
    }

    private fun onScreenLoading() {
        binding.viewPagerHotSalesHomeStore.isVisible = false
        binding.recyclerBestSellerHomeStore.isVisible = false
        binding.includedStatusLayout.groupError.isVisible = false
        binding.includedStatusLayout.progressBarState.isVisible = true
    }

    private fun onScreenLoaded() {
        binding.viewPagerHotSalesHomeStore.isVisible = true
        binding.recyclerBestSellerHomeStore.isVisible = true
        binding.includedStatusLayout.groupError.isVisible = false
        binding.includedStatusLayout.progressBarState.isVisible = false
    }

    private fun onScreenError() {
        binding.viewPagerHotSalesHomeStore.isVisible = false
        binding.recyclerBestSellerHomeStore.isVisible = false
        binding.includedStatusLayout.progressBarState.isVisible = false
        binding.includedStatusLayout.groupError.isVisible = true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}