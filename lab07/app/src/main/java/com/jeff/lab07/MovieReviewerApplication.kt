package com.jeff.lab07

import android.app.Application
import com.jeff.lab07.data.movies
import com.jeff.lab07.repositories.MovieRepository

class MovieReviewerApplication : Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}