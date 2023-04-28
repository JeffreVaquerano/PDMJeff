package com.jeff.lab05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BillboardFragment : Fragment() {
    private lateinit var actionToMovie: CardView
    private lateinit var actionToNewMovie: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_billboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        actionToMovie = view.findViewById(R.id.movie_1_card)
        actionToNewMovie = view.findViewById(R.id.action_to_new_movie)

        actionToMovie.setOnClickListener {
            it.findNavController().navigate(R.id.movieFragment)
        }

        actionToNewMovie.setOnClickListener {
            it.findNavController().navigate(R.id.createMovieFragment)
        }
    }
}