package com.jeff.parcial01

import android.app.Application
import com.jeff.parcial01.data.montanas
import com.jeff.parcial01.repositories.MontanaRepository

class MontanaReviewerApplication : Application() {
    val montanaRepository: MontanaRepository by lazy {
        MontanaRepository(montanas)
    }
}