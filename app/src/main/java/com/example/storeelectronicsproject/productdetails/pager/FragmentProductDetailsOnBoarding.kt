package com.example.storeelectronicsproject.productdetails.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.storeelectronicsproject.common.flow.launchWhenViewCreated
import com.example.storeelectronicsproject.common.fragment.getViewModelFactory
import com.example.storeelectronicsproject.databinding.RecyclerItemDetailsBinding
import com.example.storeelectronicsproject.homestore.hotsales.HOT_SALES_ID_KEY
import com.example.storeelectronicsproject.productdetails.viewmodel.ProductDetailsViewModel

class FragmentProductDetailsOnBoarding : Fragment() {

    private var _binding: RecyclerItemDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ProductDetailsViewModel by viewModels { getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = RecyclerItemDetailsBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        launchWhenViewCreated {
            viewModel.detailsImages.observe {
                Glide
                    .with(requireView())
                    .load(it.images)
                    .into(binding.imageOnBoarding)

            }
        }
        viewModel.loadDetailsImages()

    }

    companion object {
        fun create(id: String): FragmentProductDetailsOnBoarding {
            val fragment = FragmentProductDetailsOnBoarding()
            fragment.arguments = bundleOf(HOT_SALES_ID_KEY to id)
            return fragment
        }
    }

}