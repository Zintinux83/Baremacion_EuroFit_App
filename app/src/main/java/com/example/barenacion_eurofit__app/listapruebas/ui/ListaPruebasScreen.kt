package com.example.barenacion_eurofit__app.listapruebas.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.example.barenacion_eurofit__app.listapruebas.data.Prueba
import com.example.barenacion_eurofit__app.listapruebas.data.listaPruebas
import com.example.barenacion_eurofit__app.listapruebas.data.obtenerInformacionPrueba
import com.example.barenacion_eurofit__app.componentes.ThemeMenu

@Composable
fun ListaPruebasScreen(
    navController: NavHostController, // para el menú
    navigateToCalculo: () -> Unit,
    isDarkTheme: Boolean,
    onToggleDarkTheme: () -> Unit
) {
    // la consulta que introducimos al buscador
    var searchQuery by remember { mutableStateOf("") }
    // se obtienen las pruebas según la edad
    val pruebasList = listaPruebas(16)
    val categorias = listOf("Fuerza", "Flexibilidad", "Velocidad", "Agilidad", "Coordinación", "Resistencia")
    // filtrado según el SearchView
    val pruebasFiltradas = if (searchQuery.isEmpty()) {
        pruebasList
    } else {
        pruebasList.filter { it.Nombre.contains(searchQuery, ignoreCase = true) }
    }
    val backgroundColor = if (isDarkTheme) Color.Black else Color.White

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(35.dp),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(30.dp))
            ThemeMenu(isDarkTheme = isDarkTheme, onToggleDarkTheme = onToggleDarkTheme, navController = navController)
            Text(
                text = "PANTALLA DE LISTA DE PRUEBAS",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            // view para buscar una prueba
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Buscar prueba...") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            Text(
                text = "Selecciona una prueba",
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(10.dp))
        }

        // Para cada categoría, si hay pruebas, se agrega un encabezado y los items correspondientes
        categorias.forEach { categoria ->
            val pruebasCategoria = pruebasFiltradas.filter {
                it.type.trim().lowercase() == categoria.lowercase()
            }
            if (pruebasCategoria.isNotEmpty()) {
                item {
                    Text(
                        text = categoria.uppercase(),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
                items(pruebasCategoria) { prueba ->
                    TrialItem(prueba = prueba, onClick = { pruebaName ->
                        navController.navigate("calculo_notas/$pruebaName")
                    })
                }
            }
        }
    }
}


@Composable
fun TrialItem(prueba: Prueba, onClick: (String) -> Unit) {
    var showDialog by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick(prueba.Nombre) },  // pasamos el nombre de la prueba
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(prueba.Nombre, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
            Spacer(modifier = Modifier.height(8.dp))
            Text(prueba.type, fontSize = 14.sp, color = MaterialTheme.colorScheme.secondary)
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(prueba.imagen),
                contentDescription = prueba.Nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .size(170.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Puedes ver información sobre la prueba clicando aquí",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable { showDialog = true }
            )
        }
    }

    if (showDialog) {
        val informacionPrueba = obtenerInformacionPrueba(prueba.Nombre)
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Cerrar")
                }
            },
            title = {
                Text(text = informacionPrueba.nombre)
            },
            text = {
                Column {
                    Text("Descripción: ${informacionPrueba.descripcion}")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Recomendaciones: ${informacionPrueba.recomendaciones}")
                }
            }
        )
    }
}

