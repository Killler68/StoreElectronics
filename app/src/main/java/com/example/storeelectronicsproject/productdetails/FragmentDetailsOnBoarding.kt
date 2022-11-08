package com.example.storeelectronicsproject.productdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.storeelectronicsproject.common.flow.launchWhenViewCreated
import com.example.storeelectronicsproject.common.fragment.getViewModelFactory
import com.example.storeelectronicsproject.databinding.FragmentDetailsOnBoardingBinding
import com.example.storeelectronicsproject.productdetails.viewmodel.ProductDetailsViewModel


class FragmentDetailsOnBoarding : Fragment() {

    private var _binding: FragmentDetailsOnBoardingBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ProductDetailsViewModel by viewModels { getViewModelFactory() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentDetailsOnBoardingBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        launchWhenViewCreated {
            viewModel.detailsOnBoarding.observe {
                binding.imageOnBoarding.text = it.images
            }
        }
        viewModel.loadDetailsOnBoarding()
    }
}