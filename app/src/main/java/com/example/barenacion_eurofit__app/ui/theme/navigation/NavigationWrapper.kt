package com.example.barenacion_eurofit__app.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.barenacion_eurofit__app.ui.info.data.InfoScreen
import com.example.barenacion_eurofit__app.ui.login.ui.ForgotScreen
import com.example.barenacion_eurofit__app.ui.login.ui.LoginScreen
import com.example.barenacion_eurofit__app.ui.recycler.ui.CalculadoraScreen
import com.example.barenacion_eurofit__app.ui.recycler.ui.ListaPruebasScreen

@Composable
fun NavigationWrapper(
    navController: NavHostController,
    isDarkTheme: Boolean,
    onToggleDarkTheme: () -> Unit
) {
    NavHost(navController = navController, startDestination = Screens.Login().route()) {
        composable(Screens.Login().route()) {
            LoginScreen(
                navigateToInfoS = { navController.navigate(Screens.InfoS().route()) },
                navigateToForgotPass = { navController.navigate(Screens.ForgotPass(null).route()) }
            )
        }

        composable(Screens.ForgotPass(null).route()) {
            ForgotScreen(onNavigationBack = { navController.popBackStack() })
        }

        composable(Screens.InfoS().route()) {
            InfoScreen(
                navigateToRecycler = { navController.navigate(Screens.Recycler().route()) },
                isDarkTheme = isDarkTheme,
                onToggleDarkTheme = onToggleDarkTheme
            )
        }

        composable(Screens.Recycler().route()) {
            ListaPruebasScreen(navigateToCalculo = { navController.navigate(Screens.CalculoNotas().route()) })
        }

        composable(Screens.CalculoNotas().route()) {
            CalculadoraScreen(onBack = { navController.popBackStack() })
        }
    }
}




