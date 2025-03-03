package com.example.barenacion_eurofit__app.ui.recycler.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
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
        Spacer(modifier = Modifier.fillMaxWidth().height(80.dp))
        Text("PANTALLA DE CALCULADORA DE NOTAS", fontSize = 30.sp, fontWeight = FontWeight.Bold, color= Color.Blue)
        Spacer(modifier = Modifier.fillMaxWidth().height(40.dp))

        HorizontalDivider(modifier = Modifier.fillMaxWidth().height(2.dp).alpha(2f))

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
