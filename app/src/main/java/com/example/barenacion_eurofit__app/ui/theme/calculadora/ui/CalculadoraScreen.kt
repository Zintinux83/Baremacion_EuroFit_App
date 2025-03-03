package com.example.barenacion_eurofit__app.ui.recycler.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun CalculadoraScreen(
    onBack: () -> Unit
) {
    var resultado by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Calculadora de Notas", fontSize = 24.sp, modifier = Modifier.padding(16.dp))

        Text("Resultado:", fontSize = 18.sp)
        Text(resultado.toString(), fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.padding(16.dp))

        Button(
            onClick = { resultado = (resultado + 1f) % 10f },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular Nota")
        }

        Spacer(modifier = Modifier.padding(16.dp))

        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar y Volver")
        }

        Spacer(modifier = Modifier.padding(16.dp))
    }
}
