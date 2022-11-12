package com.example.storeelectronicsproject.homestore.hotsales

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.storeelectronicsproject.common.flow.launchWhenViewCreated
import com.example.storeelectronicsproject.common.fragment.getViewModelFactory
import com.example.storeelectronicsproject.databinding.FragmentHotSalesBinding
import com.example.storeelectronicsproject.homestore.viewmodel.HomeStoreViewModel

const val HOT_SALES_ID_KEY = "hotSalesIdKey"
const val IS_SHOW_NAME = "isShowName"

class FragmentHotSalesOnBoarding : Fragment() {

    private var _binding: FragmentHotSalesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeStoreViewModel by viewModels { getViewModelFactory() }

    private val hotSalesId by lazy {
        arguments?.getInt(HOT_SALES_ID_KEY)!!
    }

    private val isShowName by lazy {
        arguments?.getBoolean(IS_SHOW_NAME)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentHotSalesBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textNamePhoneItem.isVisible = isShowName!!

        launchWhenViewCreated {
            viewModel.hotSale.observe {

                binding.textNamePhoneItem.text = it.title
                binding.textDescriptionPhoneItem.text = it.subtitle

                Glide
                    .with(requireView())
                    .load(it.picture)
                    .into(binding.imageView)


            }
        }
        viewModel.loadHotSale(hotSalesId)
    }

    companion object {
        fun create(id: Int, boolean: Boolean): FragmentHotSalesOnBoarding {
            val fragment = FragmentHotSalesOnBoarding()
            fragment.arguments = bundleOf(HOT_SALES_ID_KEY to id, IS_SHOW_NAME to boolean)
            return fragment
        }
    }


}