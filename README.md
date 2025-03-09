# Baremacion_EuroFit_App

# 1. Descripción General
"Barenación Eurofit__App" es una aplicación móvil desarrollada en Kotlin con Jetpack Compose que permite a los usuarios calcular y gestionar sus resultados en pruebas físicas estandarizadas. La aplicación incluye funcionalidades como autenticación, visualización de datos personales, selección de pruebas, cálculo de notas y visualización de resultados.

---

# 2. Funcionalidades Principales

## 2.1 Autenticación de Usuario
🔹 Pantalla de Inicio de Sesión (LoginScreen):
- Permite a los usuarios ingresar su correo electrónico y contraseña.
- Botón "Iniciar Sesión" para acceder a la información del usuario.
- Opción "¿Has olvidado la contraseña?" para restablecerla.

🔹 Pantalla de Recuperación de Contraseña (ForgotScreen):
- Campo para introducir una nueva contraseña.
- Botón "Cambiar Contraseña" para guardar los cambios y volver al inicio de sesión.

---

## 2.2 Perfil de Usuario
🔹 Pantalla de Información del Usuario (InfoScreen):
- Muestra datos personales: Edad, Peso, Altura y Sexo.
- Calcula el Índice de Masa Corporal (IMC) en tiempo real.
- Botón "Ver mi IMC" para visualizar el resultado en otra pantalla.
- Botón "Ver las pruebas" para acceder a la lista de pruebas.

🔹 Pantalla de IMC (IMCScreen):
- Muestra el IMC calculado previamente en `InfoScreen`.
- Proporciona una interpretación del resultado según los estándares médicos.

---

## 2.3 Listado de Pruebas
🔹 Pantalla de Pruebas (ListaPruebasScreen):
- SearchView en la parte superior para buscar pruebas rápidamente.
- Lista dinámica de pruebas físicas clasificadas por tipo:
- Fuerza
- Flexibilidad
- Velocidad
- Agilidad
- Coordinación
- Resistencia
- Al hacer clic en una prueba, el usuario es dirigido a la pantalla de cálculo de notas.

🔹 Pantalla de Información de Pruebas:
- Cada prueba tiene una tarjeta con su nombre, tipo y una imagen ilustrativa.
- Al hacer clic en "Ver más", se muestra un diálogo emergente con la descripción detallada de la prueba y recomendaciones.

---

## 2.4 Cálculo de Notas
🔹 Pantalla de Cálculo de Notas (CalculadoraScreen):
- Se accede desde `ListaPruebasScreen` al seleccionar una prueba.
- Muestra el nombre de la prueba seleccionada.
- Permite ingresar el resultado obtenido en la prueba física.
- Botón "Calcular Nota" que evalúa el resultado según los baremos estandarizados.
- La nota varía en función de la prueba, edad y sexo del usuario.
- Botón "Guardar y Volver" para regresar a la lista de pruebas.

---

# 3. Instrucciones de Instalación

## 3.1 Requisitos Previos
📌 Entorno de Desarrollo:
- Android Studio (versión 2023.1.1 o superior).
- SDK de Android: API Level 25 (minSdk) hasta 35 (targetSdk).

📌 Dependencias necesarias:
- Material3 para la interfaz.
- Coil para la carga de imágenes.
- Navigation para la gestión de rutas entre pantallas.

---

## 3.2 Configuración del Proyecto
📌 Declarar la actividad principal en `AndroidManifest.xml`:
```xml
<activity
android:name=".MainActivity"
android:exported="true"
android:label="@string/app_name">
<intent-filter>
<action android:name="android.intent.action.MAIN" />
<category android:name="android.intent.category.LAUNCHER" />
</intent-filter>
</activity>
```

---

# 4. Instrucciones de Uso

## 4.1 Inicio de Sesión
1️⃣ Abre la aplicación y accede a la pantalla de inicio de sesión.
2️⃣ Ingresa tu correo electrónico y contraseña.
3️⃣ Presiona "Iniciar Sesión" para acceder a la información del usuario.

## 4.2 Recuperación de Contraseña
1️⃣ En la pantalla de inicio de sesión, haz clic en "¿Has olvidado la contraseña?".
2️⃣ Introduce la nueva contraseña en el campo correspondiente.
3️⃣ Pulsa "Cambiar Contraseña" para actualizar los datos y volver al login.

## 4.3 Visualización de Datos Personales
1️⃣ En `InfoScreen`, verás tus datos: Edad, Peso, Altura y Sexo.
2️⃣ Tu IMC se calculará automáticamente con los datos ingresados.
3️⃣ Presiona "Ver mi IMC" para acceder a una vista con la interpretación del resultado.
4️⃣ Haz clic en "Ver las pruebas" para acceder a la lista de ejercicios disponibles.

## 4.4 Selección de Pruebas
1️⃣ En `ListaPruebasScreen`, puedes desplazarte y visualizar las pruebas disponibles.
2️⃣ Utiliza el buscador para encontrar pruebas específicas.
3️⃣ Cada prueba tiene una imagen, nombre y tipo (ej: Velocidad).
4️⃣ Al hacer clic en una prueba, accederás a la Calculadora de Notas.

## 4.5 Cálculo de Notas
1️⃣ En `CalculadoraScreen`, verás el nombre de la prueba seleccionada.
2️⃣ Introduce el resultado obtenido en la prueba.
3️⃣ Pulsa "Calcular Nota" para evaluar el desempeño según los baremos estándar.
4️⃣ La nota obtenida se muestra en pantalla.
5️⃣ Usa "Guardar y Volver" para regresar a la lista de pruebas.

---

# 5. Implementación del Modo Oscuro
🔹 El estado del modo oscuro se maneja en `MainActivity` con `rememberSaveable`.
🔹 Se actualiza dinámicamente al cambiar el interruptor en `InfoScreen`.
🔹 Todos los componentes de la UI adaptan sus colores según el tema seleccionado.

---

# 6. Estructura de Datos

📌 Clases de Datos:
- `User`: Almacena información del usuario (edad, peso, altura, sexo).
- `Prueba`: Representa cada prueba física con nombre, tipo e imagen.
- `NotaUsuarios`: Guarda las notas obtenidas en cada prueba.

📌 Baremo de Notas:
- `calcularNota(nombrePrueba: String, resultado: Float, edad: Int, sexo: String): Float`
- Evalúa el resultado introducido según el baremo correspondiente a la prueba.

---

# 7. Navegación Entre Pantallas
📌 Jetpack Navigation con `NavHostController`.
📌 Rutas definidas en `Screens.kt` con parámetros dinámicos, como:
```kotlin
data class CalculoNotas(val prueba: String) {
fun route() = "calculo_notas/$prueba"
}
```
📌 Se pasan datos entre pantallas mediante `NavController.navigate()`.

---

# 8. Ejemplo de Cálculo de Notas
Si un usuario de 15 años y sexo masculino obtiene 25 repeticiones en "Abdominales 30s", la función `calcularNota` evaluará su rendimiento y devolverá una calificación basada en el baremo.

---

# 9. Mejoras Futuras
✔ Persistencia de datos con Base de Datos
✔ Mejor validación de campos en inicio de sesión y recuperación de contraseña.

