package com.example.storeelectronicsproject.productdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.storeelectronicsproject.R
import com.example.storeelectronicsproject.common.flow.launchWhenViewCreated
import com.example.storeelectronicsproject.common.fragment.getViewModelFactory
import com.example.storeelectronicsproject.common.navigation.NavCommand
import com.example.storeelectronicsproject.common.state.State
import com.example.storeelectronicsproject.databinding.FragmentProductDetailsBinding
import com.example.storeelectronicsproject.productdetails.model.DetailsData
import com.example.storeelectronicsproject.productdetails.model.DetailsImagesData
import com.example.storeelectronicsproject.productdetails.model.DetailsShopData
import com.example.storeelectronicsproject.productdetails.pager.adapter.ProductDetailsOnBoardingAdapter
import com.example.storeelectronicsproject.productdetails.viewholder.DetailsImagesItem
import com.example.storeelectronicsproject.productdetails.viewmodel.ProductDetailsViewModel
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter


const val KEY = "key"

class FragmentProductDetails : Fragment() {


    private var _binding: FragmentProductDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ProductDetailsViewModel by viewModels { getViewModelFactory() }

    private val imagesItemAdapter = ItemAdapter<DetailsImagesItem>()
    private val fastAdapter = GenericFastAdapter.with(listOf(imagesItemAdapter))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentProductDetailsBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arguments = requireArguments().getInt(KEY)

        setupObservables()
        setupListeners()
        with(viewModel) {
            loadDetails(arguments)
            loadDetailsShop()
            loadDetailsImages()
        }
    }

    private fun setupObservables() {
        launchWhenViewCreated {
            viewModel.apply {
                details.observe(::onDataLoadedDetails)
                detailsShop.observe(::onDataLoadedShopDetails)
                detailsImages.observe(::setOnBoardingHotSalesItems)
                navCommand.observe(::onDataLoadedNavigation)
                screenState.observe(viewLifecycleOwner, ::stateScreen)
            }
        }
    }

    private fun onDataLoadedDetails(detailsData: DetailsData) {
        binding.textNamePhoneDetails.text = detailsData.title
        binding.ratingBarDetails.rating = detailsData.rating.toFloat()

        binding.imageBackgroundCapacityDetailsTwo.setOnClickListener {
            binding.imageBackgroundCapacityDetailsTwo.isEnabled = false
            binding.imageBackgroundCapacityDetailsOne.isEnabled = true
            binding.imageBackgroundCapacityDetailsTwo.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.orange
                )
            )
            binding.textCapacity2Details.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.white
                )
            )
            binding.imageBackgroundCapacityDetailsOne.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.background_gray
                )
            )
            binding.textCapacity1Details.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.text_gray
                )
            )
        }

        binding.imageBackgroundCapacityDetailsOne.setOnClickListener {
            binding.imageBackgroundCapacityDetailsTwo.isEnabled = true
            binding.imageBackgroundCapacityDetailsOne.isEnabled = false
            binding.imageBackgroundCapacityDetailsOne.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.orange
                )
            )
            binding.textCapacity1Details.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.white
                )
            )
            binding.imageBackgroundCapacityDetailsTwo.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.background_gray
                )
            )
            binding.textCapacity2Details.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.text_gray
                )
            )
        }

        binding.textCapacity1Details.text =
            requireContext().resources.getString(
                R.string.capacity,
                detailsData.capacity.map { it[0] }.toString()
            )

        binding.textCapacity2Details.text = requireContext().resources.getString(
            R.string.capacity,
            detailsData.capacity.map { it[1] }.toString()
        )

        binding.imageBackgroundColorOneDetails.setOnClickListener {
            binding.imageColorOneDetails.isVisible = true
            binding.imageColorTwoDetails.isVisible = false
            binding.imageBackgroundColorOneDetails.isEnabled = false
            binding.imageBackgroundColorTwoDetails.isEnabled = true
        }
        binding.imageBackgroundColorTwoDetails.setOnClickListener {
            binding.imageColorOneDetails.isVisible = false
            binding.imageColorTwoDetails.isVisible = true
            binding.imageBackgroundColorOneDetails.isEnabled = true
            binding.imageBackgroundColorTwoDetails.isEnabled = false
        }

        binding.textPriceDetails.text =
            requireContext().resources.getString(
                R.string.usd,
                detailsData.price.toString()
            )
//        binding.imageBackgroundColorOneDetails.setColorFilter(ContextCompat.getColor(requireContext(), detailsData.color[0]))
//        binding.textCapacity2Details.text = detailsData.capacity[1]
    }

    private fun onDataLoadedShopDetails(detailsShopData: DetailsShopData) {
        binding.textProcessorDetails.text = detailsShopData.CPU
        binding.textCameraDetails.text = detailsShopData.camera
        binding.textRamDetails.text = detailsShopData.ssd
        binding.textHddDetails.text = detailsShopData.sd
    }

    private fun onDataLoadedNavigation(navCommand: NavCommand) {
        findNavController().navigate(navCommand.action, navCommand.command)
    }

    private fun setupListeners() {
        val arguments = requireArguments().getInt(KEY)

        binding.imageBackDetails.setOnClickListener {
            viewModel.navigateToHomeStore()
        }
        binding.includedStatusLayoutDetails.btnErrorState.setOnClickListener {
            with(viewModel) {
                loadDetails(arguments)
                loadDetailsShop()
                loadDetailsImages()
            }
        }
    }

    private fun setOnBoardingHotSalesItems(hotSalesData: DetailsImagesData) {
        val hotSalesOnBoardingAdapter = ProductDetailsOnBoardingAdapter(this)
        hotSalesOnBoardingAdapter.setItems(hotSalesData.id)
        binding.recyclerDetails.adapter = hotSalesOnBoardingAdapter
    }


    private fun stateScreen(state: State) {
        when (state) {
            State.Loading -> onScreenLoading()
            State.Loaded -> onScreenLoaded()
            State.Error -> onScreenError()
        }
    }

    private fun onScreenLoading() {
        binding.recyclerDetails.isVisible = false
        binding.cardViewDetails.isVisible = false
        binding.includedStatusLayoutDetails.backgroundState.isVisible = true
        binding.includedStatusLayoutDetails.groupError.isVisible = false
        binding.includedStatusLayoutDetails.progressBarState.isVisible = true
    }

    private fun onScreenLoaded() {
        binding.recyclerDetails.isVisible = true
        binding.cardViewDetails.isVisible = true
        binding.includedStatusLayoutDetails.backgroundState.isVisible = false
        binding.includedStatusLayoutDetails.groupError.isVisible = false
        binding.includedStatusLayoutDetails.progressBarState.isVisible = false
    }

    private fun onScreenError() {
        binding.recyclerDetails.isVisible = false
        binding.cardViewDetails.isVisible = false
        binding.includedStatusLayoutDetails.backgroundState.isVisible = true
        binding.includedStatusLayoutDetails.groupError.isVisible = true
        binding.includedStatusLayoutDetails.progressBarState.isVisible = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

