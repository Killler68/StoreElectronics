package com.example.storeelectronicsproject.productdetails.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.storeelectronicsproject.R
import com.example.storeelectronicsproject.databinding.RecyclerItemDetailsBinding
import com.example.storeelectronicsproject.productdetails.model.DetailsImagesData
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class DetailsImagesItem(private val detailsImagesData: DetailsImagesData) :
    AbstractBindingItem<RecyclerItemDetailsBinding>() {

    override fun bindView(binding: RecyclerItemDetailsBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)

        Glide
            .with(binding.root)
            .load(detailsImagesData.images)
            .into(binding.imageOnBoarding)
    }

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): RecyclerItemDetailsBinding =
        RecyclerItemDetailsBinding.inflate(inflater, parent, false)

    override val type: Int = R.id.background_details_item
}