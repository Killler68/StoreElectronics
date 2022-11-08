package com.example.storeelectronicsproject.productdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.storeelectronicsproject.common.flow.launchWhenViewCreated
import com.example.storeelectronicsproject.common.fragment.getViewModelFactory
import com.example.storeelectronicsproject.common.navigation.NavCommand
import com.example.storeelectronicsproject.databinding.FragmentProductDetailsBinding
import com.example.storeelectronicsproject.productdetails.detailsonboarding.adapter.DetailsOnBoardingAdapter
import com.example.storeelectronicsproject.productdetails.model.DetailsData
import com.example.storeelectronicsproject.productdetails.model.DetailsShopData
import com.example.storeelectronicsproject.productdetails.viewmodel.ProductDetailsViewModel


const val KEY = "key"

class FragmentProductDetails : Fragment() {


    private var _binding: FragmentProductDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ProductDetailsViewModel by viewModels { getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentProductDetailsBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arguments = requireArguments().getInt(KEY)

        setupObservables()
        setOnBoardingHotSalesItems()
        setupListeners()
        with(viewModel) {
            loadDetails(arguments)
            loadDetailsShop()
        }
    }

    private fun setupObservables() {
        launchWhenViewCreated {
            viewModel.apply {
                details.observe(::onDataLoadedDetails)
                detailsShop.observe(::onDataLoadedShopDetails)
                navCommand.observe(::onDataLoadedNavigation)
            }
        }
    }

    private fun onDataLoadedDetails(detailsData: DetailsData) {
        binding.textNamePhoneDetails.text = detailsData.title
        binding.textCapacityDetails.text = detailsData.capacity.toString()
        binding.textPriceDetails.text = detailsData.price.toString()
    }

    private fun onDataLoadedShopDetails(detailsShopData: DetailsShopData) {
        binding.textProcessorDetails.text = detailsShopData.CPU
        binding.textCameraDetails.text = detailsShopData.camera
        binding.textRamDetails.text = detailsShopData.ssd
        binding.textHddDetails.text = detailsShopData.sd
    }

    private fun onDataLoadedNavigation(navCommand: NavCommand) {
        findNavController().navigate(navCommand.action, navCommand.command)
    }

    private fun setOnBoardingHotSalesItems() {
        val onBoardingHotSalesAdapter = DetailsOnBoardingAdapter(this)
        binding.viewPagerDetails.adapter = onBoardingHotSalesAdapter
    }

    private fun setupListeners() {
        binding.imageBackDetails.setOnClickListener {
            viewModel.navigateToHomeStore()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

