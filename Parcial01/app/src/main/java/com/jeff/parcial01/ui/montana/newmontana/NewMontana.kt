package com.jeff.parcial01.ui.montana.newmontana

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jeff.parcial01.R
import com.jeff.parcial01.databinding.FragmentNewMontanaBinding
import com.jeff.parcial01.ui.montana.viewmodel.MontanaViewModel


class NewMontana : Fragment() {
    private val viewModel: MontanaViewModel by activityViewModels {
        MontanaViewModel.Factory
    }


    private lateinit var binding: FragmentNewMontanaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_new_movie, container, false)
        binding = FragmentNewMontanaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setViewModel()
        observeStatus()
    }

    private fun setViewModel() {
        binding.viewmodel = viewModel
    }

    private fun observeStatus() {
        viewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(MontanaViewModel.WRONG_INFORMATION) -> {
                    Log.d("APP_TAG", status)
                    viewModel.clearStatus()
                }

                status.equals(MontanaViewModel.MONTANA_CREATED) -> {
                    Log.d("APP_TAG", status)
                    Log.d("APP_TAG", viewModel.getMontana().toString())
                    viewModel.clearData()

                    viewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }
}