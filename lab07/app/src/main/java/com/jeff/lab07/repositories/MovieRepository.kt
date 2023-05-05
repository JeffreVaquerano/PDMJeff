package com.jeff.lab07.repositories

import com.jeff.lab07.data.model.MovieModel


class MovieRepository(private val movies: MutableList<MovieModel>) {

    fun getMovies() = movies

    fun addMovies(movie: MovieModel) = movies.add(movie)

}