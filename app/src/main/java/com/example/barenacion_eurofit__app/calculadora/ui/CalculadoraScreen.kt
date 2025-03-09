package com.example.barenacion_eurofit__app.calculadora.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.barenacion_eurofit__app.componentes.ThemeMenu
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.ui.text.input.KeyboardType
import com.example.barenacion_eurofit__app.data.User
import com.example.barenacion_eurofit__app.data.calcularNota


@Composable
fun CalculadoraScreen(
    navController: NavHostController,
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onToggleDarkTheme: () -> Unit,
    pruebaName: String,  // Nombre de la prueba seleccionado
    user: User           // Datos del usuario necesarios para el cálculo (edad y sexo)
) {
    var resultadoInput by remember { mutableStateOf("") }
    var notaCalculada by remember { mutableStateOf<Float?>(null) }
    val backgroundColor = if (isDarkTheme) Color.Black else Color.White

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        ThemeMenu(isDarkTheme = isDarkTheme, onToggleDarkTheme = onToggleDarkTheme, navController = navController)

        Text(
            text = "CALCULADORA DE NOTAS",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "Prueba: $pruebaName",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Campo para introducir la salida de mi resultado de la prueba
        TextField(
            value = resultadoInput,
            onValueChange = { resultadoInput = it },
            label = { Text("Ingresa el resultado") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val resultValue = resultadoInput.toFloatOrNull()
                if (resultValue != null) {
                    // Se calcula la nota utilizando la función que ya tienes en Baremos.kt
                    notaCalculada = calcularNota(pruebaName, resultValue, user.edad, user.sexo)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular Nota")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (notaCalculada != null) {
            Text(
                text = "La nota calculada es: $notaCalculada",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar y Volver")
        }
    }
}
