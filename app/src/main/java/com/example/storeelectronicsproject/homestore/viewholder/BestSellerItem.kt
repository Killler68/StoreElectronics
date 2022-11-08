package com.example.storeelectronicsproject.homestore.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.storeelectronicsproject.R
import com.example.storeelectronicsproject.databinding.RecyclerBestSellerItemHomeStoreBinding
import com.example.storeelectronicsproject.homestore.model.BestSellerData
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class BestSellerItem(
    private val bestSellerData: BestSellerData,
    private val onClick: (Int) -> Unit
) : AbstractBindingItem<RecyclerBestSellerItemHomeStoreBinding>() {

    override fun bindView(binding: RecyclerBestSellerItemHomeStoreBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)

        binding.recyclerBestSellerItem.setOnClickListener {
            onClick(bestSellerData.id)
        }
        binding.textNamePhoneItemBestSeller.text = bestSellerData.title
        binding.textCurrentPriceItemBestSeller.text =
            bestSellerData.price_without_discount.toString()
        binding.textPriceItemBestSeller.text = bestSellerData.discount_price.toString()

        Glide
            .with(binding.root)
            .load(bestSellerData.picture)
            .into(binding.imagePhoneItemBestSeller)

    }

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): RecyclerBestSellerItemHomeStoreBinding =
        RecyclerBestSellerItemHomeStoreBinding.inflate(inflater, parent, false)

    override val type: Int = R.id.recycler_best_seller_item
}