package com.example.barenacion_eurofit__app.ui.login.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
fun LoginScreen(
    navigateToInfoS: () -> Unit,
    navigateToForgotPass: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val buttonEnabled = email.isNotBlank() && password.isNotBlank()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Spacer(modifier = Modifier.fillMaxWidth().height(80.dp))
        Text("PANTALLA DE LOGIN", fontSize = 30.sp, fontWeight = FontWeight.Bold, color= Color.Blue)
        Spacer(modifier = Modifier.fillMaxWidth().height(40.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.fillMaxWidth().height(80.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.fillMaxWidth().height(30.dp))

        Button(
            onClick = { navigateToInfoS() },
            enabled = buttonEnabled,
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Iniciar Sesión")
        }

        Text(
            text = "¿Has olvidado la contraseña?",
            modifier = Modifier
                .padding(top = 10.dp)
                .clickable { navigateToForgotPass() },
            fontSize = 14.sp
        )
    }
}




