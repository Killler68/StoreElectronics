package com.example.storeelectronicsproject.homestore.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.storeelectronicsproject.common.flow.launchWhenViewCreated
import com.example.storeelectronicsproject.common.fragment.getViewModelFactory
import com.example.storeelectronicsproject.databinding.FragmentHotSalesBinding
import com.example.storeelectronicsproject.homestore.viewpager.viewmodel.HotSalesViewModel


class FragmentHotSales : Fragment() {

    private var _binding: FragmentHotSalesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HotSalesViewModel by viewModels { getViewModelFactory() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentHotSalesBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        launchWhenViewCreated {
            viewModel.hotSales.observe {
                binding.textNamePhoneItem.text = it.title
                binding.textDescriptionPhoneItem.text = it.subtitle
            }
        }
        viewModel.loadHotSales()
    }

}