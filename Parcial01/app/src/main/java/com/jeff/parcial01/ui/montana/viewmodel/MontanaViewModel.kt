package com.jeff.parcial01.ui.montana.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.jeff.parcial01.MontanaReviewerApplication
import com.jeff.parcial01.data.model.montanaModel
import com.jeff.parcial01.repositories.MontanaRepository

class MontanaViewModel (private val repository: MontanaRepository) : ViewModel() {
    var nombre = MutableLiveData("")
    var altura = MutableLiveData("")
    var status = MutableLiveData("")

    fun getMontana() = repository.getMontanas()
    fun addMontana(montana: montanaModel) = repository.addMontanas(montana)

    fun createMontana() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val montana = montanaModel(
            nombre.value!!,
            altura.value!!
        )

        addMontana(montana)
        clearData()

        status.value = MONTANA_CREATED
    }

    private fun validateData(): Boolean {
        when {
            nombre.value.isNullOrBlank() -> return false
            altura.value.isNullOrBlank() -> return false
        }
        return true
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    fun clearData() {
        nombre.value = ""
        altura.value = ""
    }

    fun setSelectedMontana(montana: montanaModel){
        nombre.value = montana.nombre
        altura.value = montana.altura
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MontanaReviewerApplication
                MontanaViewModel(app.montanaRepository)
            }
        }

        const val MONTANA_CREATED = "Montaña Creada"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}