package com.example.barenacion_eurofit__app.info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.barenacion_eurofit__app.componentes.ThemeMenu
import com.example.barenacion_eurofit__app.data.User

@Composable
fun InfoScreen(
    navController: NavHostController,
    user: User,
    navigateToRecycler: () -> Unit,
    navigateToIMC: (Float) -> Unit, // Ahora pasamos el IMC calculado
    navigateToResultados: () -> Unit,
    isDarkTheme: Boolean,
    onToggleDarkTheme: () -> Unit
) {
    var edad by rememberSaveable { mutableStateOf(user.edad.toString()) }
    var peso by rememberSaveable { mutableStateOf(user.peso.toString()) }
    var altura by rememberSaveable { mutableStateOf(user.altura.toString()) }
    var sexo by rememberSaveable { mutableStateOf(user.sexo) }

    // Calcular IMC cada vez que cambian peso o altura
    val imc = remember(peso, altura) {
        val pesoFloat = peso.toFloatOrNull() ?: 0f
        val alturaFloat = altura.toFloatOrNull() ?: 0f
        if (alturaFloat > 0) pesoFloat / ((alturaFloat / 100) * (alturaFloat / 100)) else 0f
    }

    val backgroundColor = if (isDarkTheme) Color.Black else Color.White

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.fillMaxWidth().height(30.dp))
        ThemeMenu(isDarkTheme = isDarkTheme, onToggleDarkTheme = onToggleDarkTheme, navController = navController)

        Text(
            text = "PANTALLA DE INFORMACIÓN DE USUARIO",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        TextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Edad") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        TextField(
            value = peso,
            onValueChange = { peso = it },
            label = { Text("Peso (kg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        TextField(
            value = altura,
            onValueChange = { altura = it },
            label = { Text("Altura (cm)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Sexo",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            val sexoOptions = listOf("Hombre", "Mujer")
            sexoOptions.forEach { option ->
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (sexo == option),
                        onClick = { sexo = option },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = MaterialTheme.colorScheme.primary,
                            unselectedColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
                        )
                    )
                    Text(
                        text = option,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }

        //################################################
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = navigateToRecycler,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text("Ver las pruebas")
        }

        Button(
            onClick = { navigateToIMC(imc) }, // Pasamos el IMC calculado
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text("Ver mi IMC")
        }

        Button(
            onClick = navigateToResultados,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text("Ver resultados de pruebas")
        }
    }
}


