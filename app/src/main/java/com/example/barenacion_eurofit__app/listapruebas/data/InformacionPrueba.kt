package com.example.barenacion_eurofit__app.listapruebas.data

data class InformacionPrueba(
    val nombre: String,
    val descripcion: String,
    val recomendaciones: String
)

fun obtenerInformacionPrueba(nombrePrueba: String): InformacionPrueba {
    return when (nombrePrueba) {
        "Abdominales de 30s" -> InformacionPrueba(
            nombre = "Abdominales de 30s",
            descripcion = "Realiza la mayor cantidad de abdominales posibles en 30 segundos.",
            recomendaciones = "Mantén la espalda recta y no fuerces el cuello."
        )
        "Flexión de tronco sentado" -> InformacionPrueba(
            nombre = "Flexión de tronco sentado",
            descripcion = "Siéntate con las piernas extendidas y trata de alcanzar los dedos de los pies.",
            recomendaciones = "No rebotes al alcanzar, mantén la posición por unos segundos."
        )
        "Test de Cooper" -> InformacionPrueba(
            nombre = "Test de Cooper",
            descripcion = "Corre la mayor distancia posible en 12 minutos.",
            recomendaciones = "Mantén un ritmo constante y respira profundamente."
        )
        "Carrera ida y vuelta 10x5m" -> InformacionPrueba(
            nombre = "Carrera ida y vuelta 10x5m",
            descripcion = "Corre de ida y vuelta entre dos puntos separados por 5 metros, 10 veces.",
            recomendaciones = "Gira rápidamente pero con cuidado de no tropezar."
        )
        "Lanzamiento de balón medicinal" -> InformacionPrueba(
            nombre = "Lanzamiento de balón medicinal",
            descripcion = "Lanza un balón medicinal lo más lejos posible.",
            recomendaciones = "Usa la fuerza de tus piernas y tu torso para un lanzamiento efectivo."
        )
        else -> InformacionPrueba(
            nombre = "Prueba desconocida",
            descripcion = "Descripción no disponible.",
            recomendaciones = "Recomendaciones no disponibles."
        )
    }
}
