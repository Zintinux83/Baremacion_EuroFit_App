package com.example.barenacion_eurofit__app.componentes

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.barenacion_eurofit__app.navigation.Screens

@Composable
fun ThemeMenu(
    isDarkTheme: Boolean,
    onToggleDarkTheme: () -> Unit,
    navController: NavHostController
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.TopEnd)) {
        IconButton(onClick = { expanded = true }) {
            Icon(Icons.Default.MoreVert, contentDescription = "More", tint = MaterialTheme.colorScheme.onBackground)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("Cambiar tema") },
                onClick = {
                    onToggleDarkTheme()
                    expanded = false
                },
                trailingIcon = {
                    Switch(
                        checked = isDarkTheme,
                        onCheckedChange = { onToggleDarkTheme() }
                    )
                }
            )
            DropdownMenuItem(
                text = { Text("Login") },
                onClick = {
                    navController.navigate(Screens.Login().route())
                    expanded = false
                }
            )
            DropdownMenuItem(
                text = { Text("Cambio de contraseña") },
                onClick = {
                    navController.navigate(Screens.ForgotPass().route())
                    expanded = false
                }
            )
            DropdownMenuItem(
                text = { Text("Información del usuario") },
                onClick = {
                    navController.navigate(Screens.InfoS().route())
                    expanded = false
                }
            )
            DropdownMenuItem(
                text = { Text("Lista de pruebas") },
                onClick = {
                    navController.navigate(Screens.Recycler().route())
                    expanded = false
                }
            )
            DropdownMenuItem(
                text = { Text("IMC") },
                onClick = {
                    navController.navigate(Screens.IMCScreen().route())
                    expanded = false
                }
            )
            DropdownMenuItem(
                text = { Text("Resultados") },
                onClick = {
                    navController.navigate(Screens.ResultadosScreen().route())
                    expanded = false
                }
            )
        }
    }
}
