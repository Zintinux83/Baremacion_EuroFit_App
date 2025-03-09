package com.example.barenacion_eurofit__app.data

data class DefaultUser(
    val type: String,
    val email: String,
    val password: String
)

val defaultUsers = listOf(
    DefaultUser(type = "Admin", email = "admin", password = "admin"),
    DefaultUser(type = "Monitor", email = "monitor", password = "monitor"),
    DefaultUser(type = "Usuario", email = "usuario", password = "usuario"),
    DefaultUser(type = "Invitado", email = "invitado", password = "invitado")
)
