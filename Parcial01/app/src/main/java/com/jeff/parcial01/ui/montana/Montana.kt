package com.jeff.parcial01.ui.montana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.jeff.parcial01.R
import com.jeff.parcial01.databinding.FragmentMontanaBinding
import com.jeff.parcial01.ui.montana.viewmodel.MontanaViewModel


class Montana : Fragment() {

    private val viewModel: MontanaViewModel by activityViewModels {
        MontanaViewModel.Factory
    }

    private lateinit var binding: FragmentMontanaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMontanaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }

    private fun setViewModel() {
        binding.viewmodel = viewModel
    }

}