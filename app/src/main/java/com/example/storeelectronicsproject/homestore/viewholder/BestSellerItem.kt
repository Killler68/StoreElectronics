package com.example.storeelectronicsproject.homestore.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.storeelectronicsproject.R
import com.example.storeelectronicsproject.databinding.RecyclerBestSellerItemHomeStoreBinding
import com.example.storeelectronicsproject.homestore.model.BestSellerData
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class BestSellerItem(
    private val bestSellerData: BestSellerData
) : AbstractBindingItem<RecyclerBestSellerItemHomeStoreBinding>() {

    override fun bindView(binding: RecyclerBestSellerItemHomeStoreBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)

        binding.textNamePhoneItemBestSeller.text = bestSellerData.name
        binding.textCurrentPriceItemBestSeller.text = bestSellerData.currencyPrice.toString()
        binding.textPriceItemBestSeller.text = bestSellerData.Price.toString()
    }

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): RecyclerBestSellerItemHomeStoreBinding =
        RecyclerBestSellerItemHomeStoreBinding.inflate(inflater, parent, false)

    override val type: Int = R.id.recycler_best_seller_item
}