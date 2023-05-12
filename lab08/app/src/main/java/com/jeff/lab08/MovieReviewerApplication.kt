package com.jeff.lab08

import android.app.Application
import com.jeff.lab08.data.movies
import com.jeff.lab08.repositories.MovieRepository

class MovieReviewerApplication : Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}