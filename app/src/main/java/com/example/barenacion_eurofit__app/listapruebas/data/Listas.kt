package com.example.barenacion_eurofit__app.listapruebas.data

import com.example.barenacion_eurofit__app.R

fun listaComun(): List<Prueba> {
    return listOf(
        Prueba(
            R.drawable.abdominales,
            "Abdominales de 30s",
            "Fuerza"
        ), Prueba(
            R.drawable.flexibilidad,
            "Flexión de tronco sentado",
            "Flexibilidad"
        ), Prueba(
            R.drawable.testcooper,
            "Test de Cooper",
            "Resistencia"
        )
    )
}

fun listaPruebas(edad: Int): List<Prueba> {

    when {
        edad <= 12 -> {
            return listaComun()
        }

        edad == 14 -> {
            return listaComun() + Prueba(
                R.drawable.carrera,
                "Carrera ida y vuelta 10x5m",
                "Velocidad"
            )
        }

        edad >= 15 -> {
            return listaComun() + Prueba(
                R.drawable.carrera,
                "Carrera ida y vuelta 10x5m",
                "Velocidad"
            ) + Prueba(
                R.drawable.lanzamientobalon,
                "Lanzamiento de balón medicinal",
                "Fuerza"
            )
        }
    }
    return emptyList()
}