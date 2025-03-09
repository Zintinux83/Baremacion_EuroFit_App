package com.example.barenacion_eurofit__app.navigation

object Screens {

    data class Login(val email: String = "usuario@mail.com") {
        fun route() = "login"
    }

    data class ForgotPass(val email: String? = null) {
        fun route() = "forgot_screen/${email.orEmpty()}"
    }

    data class InfoS(val userId: Int = MOCK_USER_ID) {
        fun route() = "info_screen/$userId"
    }

    data class Recycler(val userId: Int = MOCK_USER_ID) {
        fun route() = "lista_pruebas/$userId"
    }

    data class CalculoNotas(val prueba: String = "Carrera") {
        fun route() = "calculo_notas/$prueba"
    }

    data class IMCScreen(val imc: Float? = null) {
        fun route() = if (imc != null) "imc_screen/${imc}" else "imc_screen/{imc}"
    }

    data class ResultadosScreen(val userId: Int = MOCK_USER_ID) {
        fun route() = "resultados_screen/$userId"
    }

    const val MOCK_USER_ID = 1 // Valor predeterminado
}