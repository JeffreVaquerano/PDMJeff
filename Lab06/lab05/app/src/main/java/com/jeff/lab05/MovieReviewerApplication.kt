package com.jeff.lab05

import android.app.Application
import com.jeff.lab05.data.movies
import com.jeff.lab05.repositories.MovieRepository

class MovieReviewerApplication : Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}