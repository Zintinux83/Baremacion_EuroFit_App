# Baremacion_EuroFit_App

1. Descripción General
"Baremación Eurofit__App" es una aplicación móvil desarrollada con Jetpack Compose que permite a los usuarios gestionar y calcular notas en pruebas físicas. Incluye funcionalidades como autenticación, visualización de datos personales, selección de pruebas, cálculo de resultados basados en baremos estándar, y visualización del Índice de Masa Corporal (IMC) y resultados de pruebas.
2. Funcionalidades Principales
2.1 Autenticación de Usuario

    Pantalla de Inicio de Sesión (LoginScreen):
        Campos para ingresar correo electrónico y contraseña.
        Botón "Iniciar Sesión" para navegar a la pantalla de información.
        Enlace "¿Has olvidado la contraseña?" para acceder a la pantalla de recuperación.
    Pantalla de Recuperación de Contraseña (ForgotScreen):
        Campo para ingresar una nueva contraseña.
        Botón "Cambiar Contraseña" para guardar los cambios.

2.2 Perfil de Usuario

    Pantalla de Información (InfoScreen):
        Muestra datos del usuario: Edad, Peso, Altura, Sexo.
        Interruptor para activar/desactivar el modo oscuro.
        Botón "Ver las pruebas" para navegar a la lista de pruebas.
        Botón "Ver mi IMC" para navegar a la pantalla de IMC.
        Botón "Ver resultados de pruebas" para navegar a la pantalla de resultados.

2.3 Listado de Pruebas

    Pantalla de Pruebas (ListaPruebasScreen):
        Lista dinámica de pruebas disponibles basadas en la edad del usuario.
        Cada prueba muestra una tarjeta con imagen, nombre y tipo (ej: "Velocidad").
        Botón "Ver más" para navegar al cálculo de notas.

2.4 Cálculo de Notas

    Pantalla de Cálculo (CalculadoraScreen):
        Muestra el resultado calculado automáticamente.
        Botones para recalcular y volver a la pantalla anterior.

2.5 Índice de Masa Corporal (IMC)

    Pantalla de IMC (IMCScreen):
        Muestra el Índice de Masa Corporal (IMC) y su interpretación.
        El valor se calcula a partir de los datos del usuario (edad, peso, altura).

2.6 Resultados de Pruebas

    Pantalla de Resultados (ResultadosScreen):
        Muestra una lista de las notas de todas las pruebas realizadas.
        Cada resultado muestra el nombre de la prueba y la nota obtenida.

3. Instrucciones de Instalación
3.1 Requisitos Previos

    Entorno de Desarrollo: Android Studio (versión 2023.1.1 o superior).
    SDK de Android: API Level 25 (minSdk) a 35 (targetSdk).
    Dependencias:
        Material3 para la interfaz.
        Coil para cargar imágenes.
        Navigation para la navegación entre pantallas.

3.2 Configuración del Proyecto

    Configurar el Archivo AndroidManifest.xml:
        Asegúrate de que la actividad principal esté correctamente declarada:
        xmlCopy

        <activity
            android:name=".MainActivity"
            android:exported="true"
            android:label="@string/app_name">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

4. Instrucciones de Uso
4.1 Inicio de Sesión

    Abre la app y verás la pantalla de inicio de sesión.
    Ingresa tu correo electrónico y contraseña.
    Haz clic en "Iniciar Sesión" para acceder a tu perfil.

4.2 Recuperación de Contraseña

    En la pantalla de inicio de sesión, haz clic en "¿Has olvidado la contraseña?".
    Ingresa una nueva contraseña en el campo provisto.
    Haz clic en "Cambiar Contraseña" para guardar los cambios.

4.3 Visualización de Datos Personales

    En la pantalla de información, verás tus datos: Edad, Peso, Altura y Sexo.
    Usa el interruptor para activar/desactivar el modo oscuro.
    Haz clic en "Ver las pruebas" para ver la lista de pruebas disponibles.
    Haz clic en "Ver mi IMC" para ver tu Índice de Masa Corporal.
    Haz clic en "Ver resultados de pruebas" para ver los resultados de las pruebas realizadas.

4.4 Selección de Pruebas

    En la pantalla de listado de pruebas, desplázate para ver todas las pruebas.
    Cada prueba muestra una tarjeta con imagen, nombre y tipo.
    Haz clic en una prueba para acceder a su cálculo de notas.

4.5 Cálculo de Notas

    En la pantalla de cálculo, verás el resultado actual.
    Haz clic en "Calcular Nota" para actualizar el valor.
    Usa "Guardar y Volver" para regresar a la lista de pruebas.

4.6 Índice de Masa Corporal (IMC)

    En la pantalla de IMC, verás tu Índice de Masa Corporal y su interpretación.
    El valor se calcula automáticamente basado en tus datos personales.

4.7 Resultados de Pruebas

    En la pantalla de resultados, verás una lista de todas las pruebas realizadas y sus notas.
    Cada resultado muestra el nombre de la prueba y la nota obtenida.

5. Implementación del Modo Oscuro

    El estado del modo oscuro se gestiona mediante un MutableStateFlow en MainActivity.
    El tema se actualiza automáticamente al cambiar el interruptor en InfoScreen.

6. Estructura de Datos

    Clases de Datos:
        User: Almacena información de autenticación.
        DatosUsuario: Contiene datos personales del usuario.
        Prueba: Define las pruebas físicas con imagen, nombre, enlace y tipo.
        NotaUsuarios: Guarda notas de pruebas con el nombre, valor y ID de usuario.

7. Navegación Entre Pantallas

    Utiliza Jetpack Navigation con NavHostController.
    Las rutas están definidas en Screens.kt con parámetros dinámicos (ej: info_screen/$userId).

8. Ejemplo de Cálculo de Notas

    La función calcularNota usa baremos estándar para determinar la nota según el resultado, edad y sexo.

9. Pruebas y Validación

    Pruebas Unitarias: Usa JUnit para validar lógica de cálculo.
    Pruebas de Interfaz: Usa Espresso para probar flujos de usuario.

10. Mejoras Futuras

    Integración con una base de datos para persistir datos de usuario.
    Validación de campos en las pantallas de inicio de sesión y recuperación.
    Implementación de autenticación con Firebase o backend.
