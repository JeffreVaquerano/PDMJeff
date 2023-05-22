package com.jeff.parcial01.ui.montana.home.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jeff.parcial01.data.model.montanaModel
import com.jeff.parcial01.databinding.MontanaItemBinding


class MontanaRecyclerViewAdapter (private val clickListener: (montanaModel) -> Unit)
    : RecyclerView.Adapter<MontanaRecyclerViewHolder>() {
    private val movies = ArrayList<montanaModel>()

    fun setData(moviesList: List<montanaModel>){
        movies.clear()
        movies.addAll(moviesList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MontanaRecyclerViewHolder {
        val binding = MontanaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MontanaRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MontanaRecyclerViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, clickListener)
    }
}