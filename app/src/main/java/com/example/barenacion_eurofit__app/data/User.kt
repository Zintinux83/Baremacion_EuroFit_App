package com.example.barenacion_eurofit__app.data

data class User(
    val id: Int,
    val email: String,
    var edad: Int,
    var peso: Float,
    var altura: Float,
    var sexo: String
)
