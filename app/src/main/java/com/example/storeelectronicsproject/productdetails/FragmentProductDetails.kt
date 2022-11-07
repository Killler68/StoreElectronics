package com.example.storeelectronicsproject.productdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.storeelectronicsproject.common.flow.launchWhenViewCreated
import com.example.storeelectronicsproject.common.fragment.getViewModelFactory
import com.example.storeelectronicsproject.databinding.FragmentProductDetailsBinding
import com.example.storeelectronicsproject.productdetails.model.DetailsData
import com.example.storeelectronicsproject.productdetails.model.DetailsShopData
import com.example.storeelectronicsproject.productdetails.viewmodel.ProductDetailsViewModel


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
        setupObservables()
        with(viewModel) {
            loadDetails()
            loadDetailsShop()
        }
    }

    private fun setupObservables() {
        launchWhenViewCreated {
            viewModel.apply {
                detailsData.observe(::onDataLoadedDetails)
                detailsShopData.observe(::onDataLoadedShopDetails)
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
        binding.textHddDetails.text = detailsShopData.sd
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
