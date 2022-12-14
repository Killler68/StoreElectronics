package com.example.storeelectronicsproject.homestore.viewholder

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.storeelectronicsproject.R
import com.example.storeelectronicsproject.databinding.RecyclerCategoryItemHomeStoreBinding
import com.example.storeelectronicsproject.homestore.model.CategoryData
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class CategoryItem(
    private val categoryData: CategoryData
) : AbstractBindingItem<RecyclerCategoryItemHomeStoreBinding>() {

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun bindView(binding: RecyclerCategoryItemHomeStoreBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)

        binding.textNameCategoryItem.text = categoryData.name

        if (categoryData.isSelected) {
            binding.imageCategoryBackgroundItem.setColorFilter(
                ContextCompat.getColor(
                    binding.root.context,
                    R.color.orange
                )
            )
            binding.imageCategoryItem.setColorFilter(
                ContextCompat.getColor(
                    binding.root.context,
                    R.color.white
                )
            )
        }

        binding.backgroundCategoryItem.setOnClickListener {
            if (categoryData.isSelected) {
                categoryData.isSelected = false
                binding.imageCategoryBackgroundItem.setColorFilter(
                    ContextCompat.getColor(
                        binding.root.context,
                        R.color.white
                    )
                )
                binding.imageCategoryItem.setColorFilter(
                    ContextCompat.getColor(
                        binding.root.context,
                        R.color.gray
                    )
                )

            } else {
                categoryData.isSelected = true
                binding.imageCategoryBackgroundItem.setColorFilter(
                    ContextCompat.getColor(
                        binding.root.context,
                        R.color.orange
                    )
                )
                binding.imageCategoryItem.setColorFilter(
                    ContextCompat.getColor(
                        binding.root.context,
                        R.color.white
                    )
                )
            }
        }

        binding.imageCategoryItem.setImageDrawable(
            binding.root.resources.getDrawable(
                categoryData.image,
                binding.root.context.theme
            )
        )

    }

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): RecyclerCategoryItemHomeStoreBinding =
        RecyclerCategoryItemHomeStoreBinding.inflate(inflater, parent, false)

    override val type: Int = R.id.background_category_item
}