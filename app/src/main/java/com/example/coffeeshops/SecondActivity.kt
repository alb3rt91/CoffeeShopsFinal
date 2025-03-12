package com.example.coffeeshops

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import android.view.animation.AccelerateDecelerateInterpolator

/**
 * Actividad secundaria que muestra el nombre de la cafetería seleccionada.
 *
 * Esta actividad recibe el nombre de una cafetería desde la actividad principal y
 * lo muestra en un [TextView]. Además, se aplica una animación de deslizamiento
 * para que el texto entre desde la derecha de la pantalla. Esta actividad es invocada
 * mediante un Intent con el nombre de la cafetería.
 *
 * ## Manual de instalación:
 * 1. Asegúrate de que el proyecto esté correctamente configurado con los archivos XML de interfaz
 *    (como `activity_second.xml`) que contengan los elementos necesarios, como un `TextView` con el id
 *    `textViewHeader` para mostrar el nombre de la cafetería.
 *
 * ## Manual de configuración:
 * El nombre de la cafetería es pasado mediante un `Intent` desde la actividad principal (`MainActivity`).
 * Este nombre se obtiene en `SecondActivity` utilizando `getStringExtra()` y se asigna al `TextView`.
 * Además, se configura una animación para que el nombre de la cafetería entre de manera suave desde la derecha.
 *
 * ## Manual de administración:
 * Para personalizar esta actividad o agregar más información sobre la cafetería, puedes modificar
 * el `TextView` o agregar nuevos elementos en la interfaz, y actualizar la animación según las necesidades.
 *
 * ## Estándares de Usabilidad y Accesibilidad:
 * 1. **Contraste de texto**: El texto que muestra el nombre de la cafetería debe ser legible con un
 *    contraste suficiente con el fondo. Esto es especialmente importante para usuarios con discapacidad visual.
 * 2. **Animaciones accesibles**: Aunque la animación de deslizamiento proporciona una transición visual agradable,
 *    se debe permitir que los usuarios con sensibilidad a los movimientos puedan desactivar las animaciones desde
 *    las configuraciones de accesibilidad del dispositivo.
 * 3. **Descripciones de elementos visuales**: Aunque la actividad muestra solo un texto, se recomienda usar
 *    un `contentDescription` para el `TextView` si se añaden más elementos visuales, de manera que los
 *    usuarios con discapacidad visual puedan entender el propósito de cada componente.
 * 4. **Compatibilidad con lectores de pantalla**: Asegúrate de que el `TextView` esté accesible a través de
 *    lectores de pantalla, y se pueda leer correctamente el nombre de la cafetería cuando la actividad esté en primer plano.
 *
 *  ## Usabilidad y Accesibilidad:
 *   Se ha realizado una prueba de usabilidad y accesibilidad en esta actividad, donde se ha verificado que:
 *   1. El texto es claramente visible y tiene suficiente contraste con el fondo, garantizando la legibilidad.
 *   2. Se ha probado que la animación de entrada del texto (deslizamiento desde la derecha) es suave y no interrumpe la interacción del usuario.
 *   3. El comportamiento táctil es intuitivo y responde de manera adecuada a los toques del usuario, sin retrasos notables.
 *
 *   Herramientas utilizadas:
 *   - **Google Accessibility Scanner**: Para comprobar la accesibilidad visual y la legibilidad.
 *   - **Android Studio Profiler**: Para comprobar la fluidez de las animaciones y el rendimiento general.
 *
 *
 * @property textViewHeader El [TextView] donde se mostrará el nombre de la cafetería.
 * @property coffeeShopName El nombre de la cafetería recibido desde el Intent.
 */
class SecondActivity : AppCompatActivity() {

    companion object {
        /**
         * Constante que se utiliza como clave para pasar el nombre de la cafetería entre actividades.
         * Esta constante se utiliza en el Intent para pasar el nombre de la cafetería de la actividad
         * principal a esta actividad secundaria.
         */
        const val EXTRA_COFFEE_SHOP_NAME = "coffeeShopName"
    }

    /**
     * Método que se ejecuta cuando la actividad es creada.
     *
     * Este método recibe el nombre de la cafetería a través de un Intent,
     * configura el [TextView] para mostrar ese nombre y aplica una animación
     * de deslizamiento desde la derecha.
     *
     * ## Configuración adicional:
     * - Se asigna el nombre de la cafetería a un `TextView` con el id `textViewHeader`.
     * - Se coloca el `TextView` fuera de la pantalla (a la derecha) al inicio.
     * - Se aplica una animación con duración de 1000ms para hacer que el `TextView` entre desde la derecha.
     *
     * ## Consideraciones de Accesibilidad:
     * - Asegurarse de que el nombre de la cafetería se lea correctamente por un lector de pantalla.
     * - Incluir una descripción del `TextView` para usuarios con discapacidad visual, por ejemplo:
     *   `textViewHeader.contentDescription = "Nombre de la cafetería seleccionada"`.
     * - Verificar que los usuarios con sensibilidad a los movimientos puedan desactivar animaciones a través de
     *   las opciones de accesibilidad del dispositivo.
     *
     * @param savedInstanceState El estado guardado de la actividad, si existe. Este parámetro
     * puede ser utilizado para restaurar la actividad a su estado previo si se ha perdido o detenido.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Obtener el TextView y el nombre de la cafetería desde el Intent
        val textViewHeader: TextView = findViewById(R.id.textViewHeader)
        val coffeeShopName = intent.getStringExtra(EXTRA_COFFEE_SHOP_NAME) ?: ""

        // Asignar el nombre de la cafetería al TextView
        textViewHeader.text = coffeeShopName

        // Configuración inicial: colocar el TextView fuera de la pantalla (a la derecha)
        textViewHeader.translationX = 1500f

        // Animación optimizada utilizando ViewCompat.animate() para hacer que el TextView entre desde la derecha
        ViewCompat.animate(textViewHeader)
            .translationX(0f) // Movimiento del TextView hacia la posición original (0f)
            .setDuration(1000) // Duración de la animación en milisegundos
            .setInterpolator(AccelerateDecelerateInterpolator()) // Interpolador para suavizar el movimiento
            .start() // Iniciar la animación
    }
}
