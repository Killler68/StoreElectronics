package com.example.storeelectronicsproject.mycart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.storeelectronicsproject.common.flow.launchWhenViewCreated
import com.example.storeelectronicsproject.common.fragment.getViewModelFactory
import com.example.storeelectronicsproject.common.fragment.navigateToFragment
import com.example.storeelectronicsproject.databinding.FragmentMyCartBinding
import com.example.storeelectronicsproject.homestore.FragmentHomeStore
import com.example.storeelectronicsproject.mycart.model.BasketData
import com.example.storeelectronicsproject.mycart.model.MyCartData
import com.example.storeelectronicsproject.mycart.viewholder.BasketItem
import com.example.storeelectronicsproject.mycart.viewmodel.MyCartViewModel
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil

class FragmentMyCart : Fragment() {

    private var _binding: FragmentMyCartBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MyCartViewModel by viewModels { getViewModelFactory() }

    private val basketItemAdapter = ItemAdapter<BasketItem>()
    private val fastAdapter = GenericFastAdapter.with(listOf(basketItemAdapter))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMyCartBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.recyclerMyCart) {
            adapter = fastAdapter
            itemAnimator = null
        }

        setupObservables()
        setupListeners()
        viewModel.loadBasket()
        viewModel.loadMyCart()
    }

    private fun setupObservables() {
        launchWhenViewCreated {
            viewModel.basket.observe(::onDataLoadedBasket)
            viewModel.myCart.observe(::onDataLoadedMyCart)
        }

    }

    private fun onDataLoadedBasket(basketData: List<BasketData>) {
        FastAdapterDiffUtil[basketItemAdapter] = basketData.map { BasketItem(it) }
    }

    private fun onDataLoadedMyCart(myCartData: MyCartData) {
        binding.textTotalMyCart.text = myCartData.total.toString()
        binding.textDeliveryMyCart.text = myCartData.delivery
    }

    private fun setupListeners() {
        binding.imageBackMyCart.setOnClickListener {
            navigateToFragment(FragmentHomeStore())
        }
    }
}