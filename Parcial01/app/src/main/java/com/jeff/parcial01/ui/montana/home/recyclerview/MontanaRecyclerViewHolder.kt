package com.jeff.parcial01.ui.montana.home.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.jeff.parcial01.data.model.montanaModel
import com.jeff.parcial01.databinding.MontanaItemBinding

class MontanaRecyclerViewHolder(private val binding: MontanaItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(montana: montanaModel, clickListener: (montanaModel) -> Unit) {
        binding.textView2.text = montana.nombre
        binding.textView3.text = montana.altura

        binding.cardView.setOnClickListener {
            clickListener(montana)
        }
    }
}
