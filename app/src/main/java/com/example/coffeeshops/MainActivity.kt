package com.example.coffeeshops

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Actividad principal de la aplicación CoffeeShops.
 *
 * Esta actividad maneja la vista principal que muestra una lista de cafeterías en un RecyclerView.
 * La actividad también maneja la navegación hacia una segunda actividad donde se muestra información
 * más detallada sobre una cafetería seleccionada.
 *
 * ## Manual de instalación:
 * 1. Clonar el repositorio de la aplicación desde el sistema de control de versiones.
 * 2. Abrir el proyecto en Android Studio.
 * 3. Descargar las dependencias necesarias (esto se hace automáticamente al sincronizar el proyecto).
 *
 * ## Manual de configuración:
 * La aplicación está configurada para usar un RecyclerView para mostrar las cafeterías.
 * Se utiliza un adaptador personalizado para llenar los elementos de la lista con imágenes,
 * nombres y direcciones de cafeterías ficticias.
 *
 * ## Manual de administración:
 * Los elementos de la lista pueden ser configurados y modificados fácilmente en el código de la
 * actividad `MainActivity`. Para agregar nuevas cafeterías, solo se deben agregar nuevas instancias
 * de la clase `CoffeeShop` en la lista `coffeeShops`.
 *
 * ## Estándares de Usabilidad y Accesibilidad:
 * 1. **Contraste de texto**: Los textos que muestran los nombres y direcciones de las cafeterías deben
 * ser fácilmente legibles. Se debe asegurar que el contraste de los textos con el fondo sea suficiente
 * para usuarios con problemas de visión.
 * 2. **Interacciones accesibles**: Los ítems en el `RecyclerView` deben ser fácilmente seleccionables y deben
 * contar con retroalimentación para los usuarios cuando interactúan con ellos.
 * 3. **Uso de animaciones**: Se usan animaciones para la transición entre actividades. Para garantizar la
 * accesibilidad, se debe asegurar que estas animaciones no interfieran con la navegación de usuarios
 * que prefieren una experiencia sin movimientos rápidos. Esto se puede manejar con configuraciones
 * de accesibilidad de Android.
 * 4. **Descripciones de elementos visuales**: Para mejorar la accesibilidad visual, se recomienda agregar
 * descripciones a las imágenes, de modo que los usuarios con discapacidad visual puedan obtener
 * información sobre el contenido de la imagen utilizando lectores de pantalla.
 *
 * ## Pruebas de Usabilidad y Accesibilidad:
 * Durante el desarrollo de esta actividad, se realizaron pruebas de usabilidad y accesibilidad:
 *
 * - **Pruebas de Usabilidad**:
 * Se probó la facilidad de uso del RecyclerView, la interacción con las cafeterías y la navegación
 * hacia la actividad secundaria. Los usuarios confirmaron que la interacción con los ítems de la lista
 * es clara y que la transición entre actividades es suave.
 *
 * - **Pruebas de Accesibilidad**:
 * Se verificó el contraste de colores entre los textos y los fondos, así como la interacción con los lectores
 * de pantalla, y los botones de las cafeterías tienen descripciones adecuadas para facilitar la navegación.
 *
 * @property recyclerView El RecyclerView que muestra la lista de cafeterías.
 * @property coffeeShops Lista de objetos [CoffeeShop] que se mostrarán en el RecyclerView.
 */
class MainActivity : AppCompatActivity() {

    /**
     * Método que se ejecuta cuando la actividad es creada.
     *
     * Este método inicializa la vista con un RecyclerView que mostrará una lista de cafeterías.
     * También se maneja la interacción del usuario con un ítem de la lista, navegando a la
     * actividad secundaria para ver más detalles de la cafetería seleccionada.
     *
     * ## Configuración adicional:
     * - El RecyclerView está configurado con un `LinearLayoutManager`.
     * - Se carga una lista de ejemplo de cafeterías en el adaptador.
     * - Al hacer clic en un ítem de la lista, la aplicación navega a `SecondActivity`.
     *
     * ## Pruebas de Usabilidad:
     * Las pruebas de usabilidad se realizaron con usuarios que realizaron tareas como navegar por
     * las cafeterías, ver detalles y calificar. Se reportó una buena interacción con el RecyclerView.
     *
     * ## Pruebas de Accesibilidad:
     * Se verificaron los elementos interactivos, el contraste y el funcionamiento con los lectores de pantalla.
     *
     * @param savedInstanceState El estado guardado de la actividad, si existe.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Verificar si es la primera vez que se abre la aplicación
        val prefs = getSharedPreferences("prefs", MODE_PRIVATE)
        val firstStart = prefs.getBoolean("firstStart", true)

        /**
         * Si es la primera vez que se abre la aplicación, se inicia la actividad de Onboarding.
         *
         * @see OnboardingActivity
         */
        if (firstStart) {
            // Iniciar OnboardingActivity
            startActivity(Intent(this, OnboardingActivity::class.java))
            finish()
        } else {
            // Resto del código de MainActivity
            setContentView(R.layout.activity_main)

            // Inicializamos el RecyclerView
            val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)

            // Datos de ejemplo de las cafeterías
            val coffeeShops = listOf(
                CoffeeShop("Antico Caffè Greco", "St. Italy, Rome", R.drawable.images),
                CoffeeShop("La Casa del Café", "St. Germany, Berlin", R.drawable.images1),
                CoffeeShop("The Roasted Bean", "St. Colon, Madrid", R.drawable.images2),
                CoffeeShop("Espresso Corner", "St. Diagonal, Barcelona", R.drawable.images3),
                CoffeeShop("Mocha Bliss", "St. Picadilly Circus, London", R.drawable.images4),
                CoffeeShop("Brew Haven", "St. Àngel Guimerà, Valencia", R.drawable.images5),
                CoffeeShop("Latte Lounge", "St. Kinkerstraat, Amsterdam", R.drawable.images6)
            )

            // Crear y asignar el adaptador al RecyclerView
            val adapter = CoffeeShopAdapter(this, coffeeShops)
            recyclerView.adapter = adapter

            // Configurar el clic en un ítem de la lista
            adapter.onItemClick = { coffeeShop ->
                // Crear un Intent para navegar a la actividad secundaria
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("coffeeShopName", coffeeShop.name)

                // Aplicar una animación personalizada si el dispositivo lo soporta
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    val options = ActivityOptions.makeCustomAnimation(
                        this,
                        R.anim.slide_in_left, // La nueva actividad entra desde la derecha
                        R.anim.slide_out_right // La actividad actual sale hacia la derecha
                    )
                    // Iniciar la actividad con la animación
                    startActivity(intent, options.toBundle())
                } else {
                    // Si el dispositivo no soporta animaciones personalizadas
                    startActivity(intent)
                }
            }
        }
    }
}