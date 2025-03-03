package com.example.barenacion_eurofit__app.ui.recycler.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
//importante
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.res.painterResource
import com.example.barenacion_eurofit__app.R
import com.example.barenacion_eurofit__app.ui.recycler.data.Prueba
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.barenacion_eurofit__app.ui.recycler.data.listaPruebas

@Composable
fun ListaPruebasScreen(
    navigateToCalculo: () -> Unit
) {
    // todas las pruebas para una edad simulada (16)
    val pruebasList = listaPruebas(16)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.fillMaxWidth().height(80.dp))
        Text("PANTALLA DE LISTA DE PRUEBAS", fontSize = 30.sp, fontWeight = FontWeight.Bold, color= Color.Blue)
        Spacer(modifier = Modifier.fillMaxWidth().height(40.dp))

        Text("Selecciona una prueba", fontSize = 20.sp)
        Spacer(modifier = Modifier.fillMaxWidth().height(10.dp))

        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(pruebasList) { prueba ->
                TrialItem(
                    prueba = prueba,
                    onClick = navigateToCalculo
                )
            }
        }
    }
}

@Composable
fun TrialItem(prueba: Prueba, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(prueba.imagen),
                contentDescription = prueba.Nombre,
                modifier = Modifier
                    .size(100.dp)
                    .padding(end = 16.dp),
                contentScale = ContentScale.Crop
            )
            Column {
                Text(prueba.Nombre, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(prueba.type, fontSize = 14.sp, color = MaterialTheme.colorScheme.secondary)
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                "+",
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable { /* Navegación opcional */ }
            )
        }
    }
}

