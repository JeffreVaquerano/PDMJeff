package com.jeff.parcial01.repositories

import com.jeff.parcial01.data.model.montanaModel

//Agregando Capa Repository
class MontanaRepository(private val montanas: MutableList<montanaModel>) {

    fun getMontanas() = montanas //Fun para obtener obj
    fun addMontanas(montana: montanaModel) = montanas.add(montana) //Fun para agregar obj
}