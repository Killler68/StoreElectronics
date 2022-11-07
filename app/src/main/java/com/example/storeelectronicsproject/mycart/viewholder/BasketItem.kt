package com.example.storeelectronicsproject.mycart.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.storeelectronicsproject.R
import com.example.storeelectronicsproject.databinding.RecyclerItemMyCartBinding
import com.example.storeelectronicsproject.mycart.model.BasketData
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class BasketItem(
    private val basketData: BasketData
) : AbstractBindingItem<RecyclerItemMyCartBinding>() {

    override fun bindView(binding: RecyclerItemMyCartBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)

        binding.textNameMyCart.text = basketData.title
        binding.textPriceMyCart.text = basketData.price.toString()

    }

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): RecyclerItemMyCartBinding = RecyclerItemMyCartBinding.inflate(inflater, parent, false)

    override val type: Int = R.id.recycler_my_cart_item
}