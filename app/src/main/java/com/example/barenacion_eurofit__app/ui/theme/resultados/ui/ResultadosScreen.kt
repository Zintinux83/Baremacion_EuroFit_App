package com.example.barenacion_eurofit__app.ui.theme.resultados.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.barenacion_eurofit__app.ui.theme.calculadora.data.NotaUsuarios

@Composable
fun ResultadosScreen(userId: Int) {
    val resultados = remember {
        listOf(
            NotaUsuarios(nombrePrueba = "Carrera 10x5m", nota = 8.5f, userid = userId),
            NotaUsuarios(nombrePrueba = "Test de Cooper", nota = 9.0f, userid = userId),
            NotaUsuarios(nombrePrueba = "Flexión de tronco sentado", nota = 7.8f, userid = userId),
            NotaUsuarios(nombrePrueba = "Abdominales de 30s", nota = 8.2f, userid = userId),
            NotaUsuarios(nombrePrueba = "Lanzamiento de balón medicinal", nota = 7.5f, userid = userId),
            NotaUsuarios(nombrePrueba = "Velocidad", nota = 8.0f, userid = userId),
            NotaUsuarios(nombrePrueba = "Fuerza", nota = 8.3f, userid = userId),
            NotaUsuarios(nombrePrueba = "Resistencia", nota = 8.7f, userid = userId),
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.fillMaxWidth().height(80.dp))
        Text("PANTALLA DE RESULTADOS", fontSize = 30.sp, fontWeight = FontWeight.Bold, color= Color.Blue)
        Spacer(modifier = Modifier.fillMaxWidth().height(40.dp))

        Text("Resultados de Pruebas", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(resultados) { resultado ->
                Text("${resultado.nombrePrueba}: ${resultado.nota}", fontSize = 18.sp)
            }
        }
    }
}