package com.example.barenacion_eurofit__app.ui.theme.imc.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pruebas_fisicas.ui.info.data.DatosUsuario

@Composable
fun IMCScreen(userId: Int) {
    val user = remember { DatosUsuario(edad = 16, peso = 60f, altura = 160f, sexo = "Hombre", userId = userId) }
    val imc = remember { calcularIMC(user) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.fillMaxWidth().height(80.dp))
        Text("PANTALLA DE IMC", fontSize = 30.sp, fontWeight = FontWeight.Bold, color= Color.Blue)
        Spacer(modifier = Modifier.fillMaxWidth().height(40.dp))

        Text("Tu Índice de Masa Corporal (IMC) es: ${imc.toString().take(4)}", fontSize = 24.sp)
        Text("Interpretación: ${interpretarIMC(imc)}", fontSize = 18.sp)
    }
}

fun calcularIMC(user: DatosUsuario): Float {
    return user.peso / (user.altura / 100f * user.altura / 100f)
}

fun interpretarIMC(imc: Float): String {
    return when {
        imc < 18.5 -> "Bajo peso"
        imc in 18.5..24.9 -> "Peso saludable"
        imc in 25.0..29.9 -> "Sobrepeso"
        else -> "Obesidad"
    }
}