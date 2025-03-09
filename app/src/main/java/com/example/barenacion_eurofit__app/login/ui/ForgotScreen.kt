package com.example.barenacion_eurofit__app.login.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.barenacion_eurofit__app.componentes.ThemeMenu

@Composable
fun ForgotScreen(
    onNavigationBack: () -> Unit,
    isDarkTheme: Boolean,
    onToggleDarkTheme: () -> Unit,
    navController: NavHostController
) {
    var password by rememberSaveable { mutableStateOf("") }

    val backgroundColor = if (isDarkTheme) Color.Black else Color.White

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor)
            .padding(18.dp)
    ) {
        Spacer(modifier = Modifier.fillMaxWidth().height(50.dp))
        ThemeMenu(isDarkTheme = isDarkTheme, onToggleDarkTheme = onToggleDarkTheme, navController = navController)

        Text(
            text = "PANTALLA DE CAMBIO DE CONTRASEÑA",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Cambiar Contraseña",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onBackground
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Nueva contraseña") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        )

        Button(
            onClick = { onNavigationBack() },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Cambiar Contraseña")
        }
    }
}
