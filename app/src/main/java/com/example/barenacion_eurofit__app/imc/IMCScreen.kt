package com.example.barenacion_eurofit__app.imc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.barenacion_eurofit__app.componentes.ThemeMenu

@Composable
fun IMCScreen(
    navController: NavHostController,
    imc: Float, // Ahora recibimos el IMC directamente
    isDarkTheme: Boolean,
    onToggleDarkTheme: () -> Unit
) {
    val backgroundColor = if (isDarkTheme) Color.Black else Color.White

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor)
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        ThemeMenu(isDarkTheme = isDarkTheme, onToggleDarkTheme = onToggleDarkTheme, navController = navController)

        Text(
            text = "PANTALLA DE IMC",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Tu Índice de Masa Corporal (IMC) es: ${"%.2f".format(imc)}",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onBackground
        )

        Text(
            text = "Interpretación: ${interpretarIMC(imc)}",
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

fun interpretarIMC(imc: Float): String {
    return when {
        imc < 18.5 -> "Bajo peso"
        imc in 18.5..24.9 -> "Peso saludable"
        imc in 25.0..29.9 -> "Sobrepeso"
        else -> "Obesidad"
    }
}



