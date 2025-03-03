package com.example.barenacion_eurofit__app.ui.login.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ForgotScreen(onNavigationBack: () -> Unit) {
    var password by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)
    ) {
        Spacer(modifier = Modifier.fillMaxWidth().height(180.dp))
        Text("PANTALLA DE CAMBIO DE CONTRASEÑA", fontSize = 30.sp, fontWeight = FontWeight.Bold, color= Color.Blue)
        Spacer(modifier = Modifier.fillMaxWidth().height(40.dp))

        Text("Cambiar Contraseña")

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Nueva contraseña") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { onNavigationBack() },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Cambiar Contraseña")
        }
    }
}
