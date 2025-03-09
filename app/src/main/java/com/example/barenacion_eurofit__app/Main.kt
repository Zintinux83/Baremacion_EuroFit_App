package com.example.barenacion_eurofit__app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.example.barenacion_eurofit__app.ui.theme.Barenacion_Eurofit__AppTheme
import com.example.barenacion_eurofit__app.navigation.NavigationWrapper

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkTheme by rememberSaveable { mutableStateOf(false) }
            val navController = rememberNavController() // Inicializar NavController correctamente

            Barenacion_Eurofit__AppTheme(darkTheme = isDarkTheme) {
                NavigationWrapper(
                    isDarkTheme = isDarkTheme,
                    onToggleDarkTheme = { isDarkTheme = !isDarkTheme },
                    navController = navController
                )
            }
        }
    }
}
