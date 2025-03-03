package com.example.barenacion_eurofit__app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.rememberNavController
import com.example.barenacion_eurofit__app.ui.theme.Barenacion_Eurofit__AppTheme
import com.example.barenacion_eurofit__app.ui.theme.navigation.NavigationWrapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainActivity : ComponentActivity() {
    private val _isDarkTheme = MutableStateFlow(false)
    val isDarkTheme: StateFlow<Boolean> = _isDarkTheme

    @SuppressLint("StateFlowValueCalledInComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Barenacion_Eurofit__AppTheme(
                darkTheme = isDarkTheme.value
            ) {
                val navController = rememberNavController()
                val currentIsDarkTheme = isDarkTheme.collectAsState().value
                NavigationWrapper(
                    navController = navController,
                    isDarkTheme = currentIsDarkTheme,
                    onToggleDarkTheme = { _isDarkTheme.value = !_isDarkTheme.value }
                )
            }
        }
    }

}


