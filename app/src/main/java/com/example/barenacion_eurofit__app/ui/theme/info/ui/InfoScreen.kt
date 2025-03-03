package com.example.barenacion_eurofit__app.ui.info.data

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun InfoScreen(
    navigateToRecycler: () -> Unit,
    navigateToIMC: () -> Unit,
    navigateToResultados: () -> Unit,
    isDarkTheme: Boolean,
    onToggleDarkTheme: () -> Unit
) {
    var edad by remember { mutableStateOf(16) }
    var peso by remember { mutableStateOf(60f) }
    var altura by remember { mutableStateOf(160f) }
    var sexo by remember { mutableStateOf("Hombre") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.fillMaxWidth().height(80.dp))
        Text("PANTALLA DE INFORMACIÓN DE USUARIO", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.Blue)
        Spacer(modifier = Modifier.fillMaxWidth().height(40.dp))

        Text("Edad: $edad", modifier = Modifier.padding(8.dp))
        Text("Peso: ${peso}kg", modifier = Modifier.padding(8.dp))
        Text("Altura: ${altura}cm", modifier = Modifier.padding(8.dp))
        Text("Sexo: $sexo", modifier = Modifier.padding(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Modo Oscuro", fontSize = 16.sp)
            Switch(
                checked = isDarkTheme,
                onCheckedChange = { onToggleDarkTheme() },
                modifier = Modifier
                    .size(45.dp)
            )
        }

        Button(
            onClick = navigateToRecycler,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Ver las pruebas")
        }

        Button(
            onClick = navigateToIMC,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Ver mi IMC")
        }

        Button(
            onClick = navigateToResultados,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Ver resultados de pruebas")
        }
    }
}




