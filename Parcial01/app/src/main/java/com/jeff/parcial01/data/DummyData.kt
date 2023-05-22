package com.jeff.parcial01.data

import com.jeff.parcial01.data.model.montanaModel

val nombre = "Monte Everest"
val altura = "800"

val nombre2 = "Boqueron"
val altura2 = "500"

val montanas = mutableListOf(
    montanaModel(nombre, altura),
    montanaModel(nombre2, altura2)
)