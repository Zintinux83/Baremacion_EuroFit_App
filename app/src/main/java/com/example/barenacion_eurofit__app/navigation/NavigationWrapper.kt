package com.example.barenacion_eurofit__app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.barenacion_eurofit__app.calculadora.ui.CalculadoraScreen
import com.example.barenacion_eurofit__app.imc.IMCScreen
import com.example.barenacion_eurofit__app.info.InfoScreen
import com.example.barenacion_eurofit__app.listapruebas.ui.ListaPruebasScreen
import com.example.barenacion_eurofit__app.data.User
import com.example.barenacion_eurofit__app.login.ui.ForgotScreen
import com.example.barenacion_eurofit__app.login.ui.LoginScreen
import com.example.barenacion_eurofit__app.resultados.ResultadosScreen

@Composable
fun NavigationWrapper(
    isDarkTheme: Boolean,
    onToggleDarkTheme: () -> Unit,
    navController: NavHostController
) {
    // ponemos un usuario por defecto, pero podremos modificar
    // los datos fisicos del usuario en la pantalla de info
    val mockUser = User(
        id = 1,
        email = "usuario@mail.com",
        edad = 16,
        peso = 60f,
        altura = 160f,
        sexo = "Hombre"
    )

    NavHost(navController = navController, startDestination = Screens.Login().route()) {
        composable(Screens.Login().route()) {
            LoginScreen(
                navController = navController, // Pasar navController correctamente
                navigateToInfoS = { navController.navigate(Screens.InfoS(mockUser.id).route()) },
                navigateToForgotPass = { navController.navigate(Screens.ForgotPass(null).route()) },
                isDarkTheme = isDarkTheme,
                onToggleDarkTheme = onToggleDarkTheme
            )
        }

        composable(Screens.ForgotPass(null).route()) {
            ForgotScreen(
                onNavigationBack = { navController.popBackStack() },
                isDarkTheme = isDarkTheme,
                onToggleDarkTheme = onToggleDarkTheme,
                navController = navController
            )
        }

        composable(Screens.InfoS(mockUser.id).route()) {
            InfoScreen(
                navController = navController,
                user = mockUser,
                navigateToRecycler = { navController.navigate(Screens.Recycler(mockUser.id).route()) },
                navigateToIMC = { imc ->
                    navController.navigate("imc_screen/$imc")
                },
                navigateToResultados = { navController.navigate(Screens.ResultadosScreen(mockUser.id).route()) },
                isDarkTheme = isDarkTheme,
                onToggleDarkTheme = onToggleDarkTheme
            )
        }

        // Hemos calculado el IMC en la pantalla anterior y en la de
        // IMC pasamos el resultado del calculo
        composable("imc_screen/{imc}") { backStackEntry ->
            val imc = backStackEntry.arguments?.getString("imc")?.toFloatOrNull() ?: 0f
            IMCScreen(
                imc = imc,
                isDarkTheme = isDarkTheme,
                onToggleDarkTheme = onToggleDarkTheme,
                navController = navController
            )
        }


        composable(Screens.ResultadosScreen(mockUser.id).route()) {
            ResultadosScreen(
                userId = mockUser.id,
                isDarkTheme = isDarkTheme,
                onToggleDarkTheme = onToggleDarkTheme,
                navController = navController
            )
        }

        composable(Screens.Recycler(mockUser.id).route()) {
            ListaPruebasScreen(
                navController = navController,
                navigateToCalculo = { navController.navigate(Screens.CalculoNotas().route()) },
                isDarkTheme = isDarkTheme,
                onToggleDarkTheme = onToggleDarkTheme
            )
        }

        composable("calculo_notas/{prueba}") { backStackEntry ->
            val pruebaName = backStackEntry.arguments?.getString("prueba") ?: "Carrera"
            // aquí usamos mockUser
            CalculadoraScreen(
                navController = navController,
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkTheme,
                onToggleDarkTheme = onToggleDarkTheme,
                pruebaName = pruebaName,
                user = mockUser
            )
        }

    }
}

