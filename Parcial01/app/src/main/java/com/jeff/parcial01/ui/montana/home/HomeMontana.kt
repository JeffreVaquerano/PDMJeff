package com.jeff.parcial01.ui.montana.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jeff.parcial01.R
import com.jeff.parcial01.data.model.montanaModel
import com.jeff.parcial01.databinding.FragmentHomeMontanaBinding
import com.jeff.parcial01.ui.montana.home.recyclerview.MontanaRecyclerViewAdapter
import com.jeff.parcial01.ui.montana.viewmodel.MontanaViewModel


class HomeMontana : Fragment() {
    private val movieViewModel: MontanaViewModel by activityViewModels {
        MontanaViewModel.Factory
    }

    private lateinit var adapter: MontanaRecyclerViewAdapter
    private lateinit var binding: FragmentHomeMontanaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeMontanaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)

        binding.floatingActionButton.setOnClickListener {
            movieViewModel.clearData()
            it.findNavController().navigate(R.id.action_homeMontana_to_newMontana)
        }
    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = MontanaRecyclerViewAdapter { selectedMontana ->
            showSelectedItem(selectedMontana)
        }

        binding.recyclerView.adapter = adapter
        displayMovie()
    }

    private fun showSelectedItem(montana: montanaModel) {
        movieViewModel.setSelectedMontana(montana)
        findNavController().navigate(R.id.action_homeMontana_to_montana)
    }

    private fun displayMovie() {
        adapter.setData(movieViewModel.getMontana())
        adapter.notifyDataSetChanged()
    }
}