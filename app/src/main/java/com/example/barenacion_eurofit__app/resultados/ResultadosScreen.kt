package com.example.barenacion_eurofit__app.resultados

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.barenacion_eurofit__app.calculadora.data.NotaUsuarios
import com.example.barenacion_eurofit__app.componentes.ThemeMenu

@Composable
fun ResultadosScreen(
    navController: NavHostController, //para el menu
    userId: Int,
    isDarkTheme: Boolean,
    onToggleDarkTheme: () -> Unit
) {
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

    val backgroundColor = if (isDarkTheme) Color.Black else Color.White

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor)
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.fillMaxWidth().height(30.dp))
        ThemeMenu(isDarkTheme = isDarkTheme, onToggleDarkTheme = onToggleDarkTheme, navController = navController)

        Text(
            text = "PANTALLA DE RESULTADOS",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Resultados de Pruebas",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(resultados) { resultado ->
                Text(
                    text = "${resultado.nombrePrueba}: ${resultado.nota}",
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}
