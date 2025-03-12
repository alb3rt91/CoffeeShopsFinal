
# CoffeeShops - Proyecto de Aplicación Móvil

## Descripción
La aplicación **CoffeeShops** muestra una lista de cafeterías ficticias y permite a los usuarios ver información adicional sobre cada una al hacer clic en ella. La aplicación está construida utilizando Android y se enfoca en la usabilidad y accesibilidad para una experiencia de usuario fluida y sencilla.

## Funcionalidades
- Visualización de una lista de cafeterías con nombre, dirección y calificación.
- Navegación entre actividades con animaciones personalizadas.
- Visualización del nombre de la cafetería seleccionada en una nueva actividad.
- La aplicación es accesible y permite la interacción mediante lector de pantalla.

## Requisitos
- Android Studio.
- Android 5.0 Lollipop (API 21) o superior.

## Instalación
1. Clona el repositorio:
   ```bash
   git clone https://github.com/alb3rt91/CoffeeShopsFinal.git
   ```

2. Abre el proyecto en **Android Studio**.

3. Sincroniza el proyecto con Gradle para descargar las dependencias necesarias.

4. Corre la aplicación en un dispositivo o emulador.

## Estructura del Proyecto

- **MainActivity**: La actividad principal que muestra la lista de cafeterías.
- **SecondActivity**: La actividad secundaria que muestra el nombre de la cafetería seleccionada.
- **OnboardingActivity**: La actividad que muestra el asistente de instalación (onboarding) al usuario la primera vez que inicia la aplicación.
- **Adaptadores**: 
  - Se utiliza un adaptador personalizado (CoffeeShopAdapter) para gestionar los elementos del RecyclerView en MainActivity.
  - Se utiliza un adaptador (OnboardingAdapter) para gestionar las pantallas del asistente de instalación en OnboardingActivity.

## Estrategia de Pruebas

### Objetivo de las pruebas
Garantizar que la aplicación funcione correctamente en todas las plataformas, con un enfoque en la usabilidad, accesibilidad y rendimiento.

### 1. **Pruebas Funcionales**
- Verificar que la navegación entre `MainActivity` y `SecondActivity` funcione correctamente.
- Validar que los datos de las cafeterías (nombre, dirección, imagen) se muestren correctamente en el `RecyclerView`.
- Verificar que la calificación de las cafeterías se muestre correctamente y funcione como se espera.

### 2. **Pruebas de Usabilidad**
- Validar que los elementos interactivos sean fáciles de usar, con un tamaño adecuado y sean accesibles.
- Verificar que la navegación de la interfaz sea intuitiva y clara para el usuario.
- Realizar pruebas con usuarios para asegurar que la aplicación sea fácil de usar.

### 3. **Pruebas de Accesibilidad**
- Comprobar que la aplicación sea compatible con **TalkBack** (lector de pantalla).
- Verificar que el contraste de los colores y la legibilidad del texto sean adecuados para personas con discapacidades visuales.

### 4. **Pruebas de Rendimiento**
- Comprobar que la aplicación funcione de manera fluida en dispositivos con diferentes configuraciones y tamaños de pantalla.
- Verificar que la animación de la transición entre actividades se ejecute correctamente sin afectar el rendimiento.

### 5. **Pruebas de Seguridad**
- Verificar que la aplicación no acceda ni exponga información sensible sin la debida autorización.
- Asegurar que los permisos sean solicitados de manera adecuada.

### Herramientas Utilizadas:
- **Google Accessibility Scanner**: Para evaluar la accesibilidad de la interfaz.
- **Android Studio Profiler**: Para analizar el rendimiento de la aplicación.
- **Espresso** y **UI Automator**: Para realizar pruebas automatizadas de la interfaz de usuario.

### 6. **Pruebas de Compatibilidad**
- Asegurar que la aplicación funcione correctamente en dispositivos con diferentes versiones de Android (Android 5.0 Lollipop en adelante).

### 7. **Pruebas Automáticas**
- Se recomienda escribir pruebas unitarias utilizando **JUnit** y pruebas de interfaz utilizando **Espresso**.
- Realizar pruebas automáticas de navegación, interacción con el `RecyclerView`, y validación de elementos en la interfaz.

## Contribuciones
Si deseas contribuir a este proyecto, por favor sigue estos pasos:

1. Haz un fork del proyecto.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios.
4. Realiza un commit de tus cambios (`git commit -m 'Agregada nueva funcionalidad'`).
5. Sube tus cambios al repositorio (`git push origin feature/nueva-funcionalidad`).
6. Crea un Pull Request desde tu rama.

## Licencia
Este proyecto está licenciado bajo la licencia MIT.
