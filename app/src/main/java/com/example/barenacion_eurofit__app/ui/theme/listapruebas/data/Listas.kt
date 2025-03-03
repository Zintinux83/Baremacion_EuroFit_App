package com.example.barenacion_eurofit__app.ui.recycler.data

import com.example.barenacion_eurofit__app.R

fun listaComun(): List<Prueba> {
    return listOf(
        Prueba(
            R.drawable.abdominales,
            "Abdominales de 30s",
            "https://en.wikipedia.org/wiki/Abdominal_exercise",
            "Fuerza"
        ), Prueba(
            R.drawable.flexibilidad,
            "Flexión de tronco sentado",
            "https://studylib.es/doc/5485201/test-de-flexi%C3%B3n-de-tronco-sentado--flexibilidad-",
            "Flexibilidad"
        ), Prueba(
            R.drawable.testcooper,
            "Test de Cooper",
            "https://en.wikipedia.org/wiki/Cooper_test",
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
                "https://entrenamientopruebasfisicas.blogspot.com/2010/05/prueba-de-velocidad-10-x-5-metros.html",
                "Velocidad"
            )
        }

        edad >= 15 -> {
            return listaComun() + Prueba(
                R.drawable.carrera,
                "Carrera ida y vuelta 10x5m",
                "https://entrenamientopruebasfisicas.blogspot.com/2010/05/prueba-de-velocidad-10-x-5-metros.html",
                "Velocidad"
            ) + Prueba(
                R.drawable.lanzamientobalon,
                "Lanzamiento de balón medicinal",
                "https://efisicas.com/tutorial-balon-medicinal-oposiciones/",
                "Fuerza"
            )
        }
    }
    return emptyList()
}