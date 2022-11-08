package com.example.storeelectronicsproject.homestore.filteroptions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.storeelectronicsproject.R
import com.example.storeelectronicsproject.databinding.FragmentDialogFilterOptionsBinding

class DialogFragmentFilterOptions : DialogFragment() {

    private var _binding: FragmentDialogFilterOptionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentDialogFilterOptionsBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

}