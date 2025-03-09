package com.example.barenacion_eurofit__app.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.barenacion_eurofit__app.R
import com.example.barenacion_eurofit__app.componentes.ThemeMenu
import com.example.barenacion_eurofit__app.ui.theme.LightPinkBackground
import com.example.barenacion_eurofit__app.ui.theme.DarkPinkBackground
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavHostController
import com.example.barenacion_eurofit__app.data.DefaultUser
import com.example.barenacion_eurofit__app.ui.theme.Pink80
import com.example.barenacion_eurofit__app.ui.theme.Purple80
import com.example.barenacion_eurofit__app.ui.theme.Teal200

@Composable
fun LoginScreen(
    navController: NavHostController,
    navigateToInfoS: () -> Unit,
    navigateToForgotPass: () -> Unit,
    isDarkTheme: Boolean,
    onToggleDarkTheme: () -> Unit
) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isInvitedUser by rememberSaveable { mutableStateOf(false) }
    var isDefaultUser by rememberSaveable { mutableStateOf(false) }
    var emailError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var showUserInfoDialog by remember { mutableStateOf(false) } // Variable para la ventana emergente

    // Accedemos a los usuarios predeterminados desde DefaultUsers.kt
    val defaultUsers = com.example.barenacion_eurofit__app.data.defaultUsers

    // Cuando el switch de invitado esté activado, rellena los campos con las credenciales del usuario "Invitado"
    LaunchedEffect(isInvitedUser) {
        if (isInvitedUser) {
            val invitedUser = defaultUsers.find { it.type == "Invitado" }
            invitedUser?.let {
                email = it.email
                password = it.password
            }
        }
    }

    // Cuando el switch de usuario predeterminado esté activado, limpia los campos
    LaunchedEffect(isDefaultUser) {
        if (isDefaultUser) {
            email = ""
            password = ""
        }
    }

    val validateCredentials = { user: DefaultUser ->
        email == user.email && password == user.password
    }

    val backgroundColor = if (isDarkTheme) Color.Black else Color.White
    val boxBackgroundColor = if (isDarkTheme) DarkPinkBackground else LightPinkBackground
    val backgroundImage = if (isDarkTheme) R.drawable.dark2560x1440 else R.drawable.light2560x1440

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor)
    ) {
        Image(
            painter = painterResource(id = backgroundImage),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ThemeMenu(isDarkTheme = isDarkTheme, onToggleDarkTheme = onToggleDarkTheme, navController = navController)

            Spacer(modifier = Modifier.height(30.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = boxBackgroundColor.copy(alpha = 0.5f))
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = "PANTALLA DE LOGIN",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    // Campo de email
                    TextField(
                        value = email,
                        onValueChange = { newValue ->
                            email = newValue
                            emailError = ""
                            showError = false
                        },
                        label = { Text("Email") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
                        isError = emailError.isNotEmpty() || (showError && email.isEmpty())
                    )
                    if (emailError.isNotEmpty() || (showError && email.isEmpty())) {
                        Text(
                            text = emailError.ifEmpty { "Por favor, introduce un email" },
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }

                    // Campo de contraseña
                    TextField(
                        value = password,
                        onValueChange = { newValue ->
                            password = newValue
                            passwordError = ""
                            showError = false
                        },
                        label = { Text("Contraseña") },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                        isError = passwordError.isNotEmpty() || (showError && password.isEmpty())
                    )
                    if (passwordError.isNotEmpty() || (showError && password.isEmpty())) {
                        Text(
                            text = passwordError.ifEmpty { "Por favor, introduce una contraseña" },
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }

                    // Switches
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Switch(
                            checked = isInvitedUser,
                            onCheckedChange = { newValue ->
                                isInvitedUser = newValue
                                isDefaultUser = false
                            },
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f)
                        )
                        Text(
                            text = "Iniciar sesión como invitado",
                            modifier = Modifier.weight(1f),
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Switch(
                            checked = isDefaultUser,
                            onCheckedChange = { newValue ->
                                isDefaultUser = newValue
                                isInvitedUser = false
                            },
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f)
                        )
                        Text(
                            text = "Iniciar sesión como usuario predeterminado",
                            modifier = Modifier.weight(1f),
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }

                    // Botón de inicio de sesión
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            showError = true
                            var isValid = true
                            if (!isInvitedUser && !isDefaultUser) {
                                if (email.isEmpty()) {
                                    emailError = "Por favor, introduce un email"
                                    isValid = false
                                }
                                if (password.isEmpty()) {
                                    passwordError = "Por favors, introduce una contraseña"
                                    isValid = false
                                }
                            }

                            if (isValid) {
                                val matchedUser = defaultUsers.find { user ->
                                    validateCredentials(user)
                                }

                                if (matchedUser != null) {
                                    // Navegar a InfoScreen
                                    navigateToInfoS()
                                } else {
                                    // Credenciales incorrectas
                                    emailError = "Email o contraseña incorrectos"
                                    passwordError = "Email o contraseña incorrectos"
                                }
                            }
                        },
                        enabled = !(email.isEmpty() || password.isEmpty()),
                        modifier = Modifier.fillMaxWidth().padding(top = 12.dp)
                    ) {
                        Text("Iniciar Sesión")
                    }

                    // Enlace a recuperación de contraseña
                    Text(
                        text = "¿Has olvidado la contraseña?",
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .clickable { navigateToForgotPass() },
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }

        Text(
            text = "Información",
            modifier = Modifier
                .padding(top = 10.dp)
                .clickable { navigateToForgotPass() },
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onBackground
        )

        // Icono de información se encuentra abajo ######################################
        IconButton(
            onClick = { showUserInfoDialog = true },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "Mostrar usuarios predeterminados",
                tint = if (isDarkTheme) Teal200 else Pink80
            )
        }

        // Ventana emergente con información de usuarios
        if (showUserInfoDialog) {
            AlertDialog(
                onDismissRequest = { showUserInfoDialog = false },
                confirmButton = {
                    TextButton(onClick = { showUserInfoDialog = false }) {
                        Text("Cerrar")
                    }
                },
                title = { Text("Usuarios Predeterminados") },
                text = {
                    Column {
                        defaultUsers.forEach { user ->
                            Row(
                                modifier = Modifier.padding(vertical = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Tipo: ${user.type}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                                Spacer(modifier = Modifier.width(16.dp))
                                Text(
                                    text = "Email: ${user.email}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                                Spacer(modifier = Modifier.width(16.dp))
                                Text(
                                    text = "Contraseña: ${user.password}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.error.copy(alpha = 0.8f)
                                )
                            }
                        }
                    }
                }
            )
        }
    }
}
