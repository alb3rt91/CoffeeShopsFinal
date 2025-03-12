package com.example.coffeeshops

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

/**
 * Actividad que muestra un asistente de instalación (onboarding) al usuario.
 *
 * Esta actividad utiliza un ViewPager2 para mostrar una serie de pantallas que guían al usuario
 * a través de las funciones principales de la aplicación. Se muestra solo la primera vez que el
 * usuario abre la aplicación.
 *
 * ## Manual de instalación:
 * 1. Asegúrate de que los archivos de layout para las pantallas de onboarding estén creados
 * en la carpeta `res/layout`.
 * 2. Asegúrate de que `OnboardingAdapter` esté configurado correctamente.
 *
 * ## Manual de configuración:
 * Las pantallas de onboarding se definen en el adaptador `OnboardingAdapter`.
 * Puedes personalizar el contenido de cada pantalla modificando los archivos de layout
 * correspondientes.
 *
 * ## Manual de administración:
 * Para agregar o eliminar pantallas de onboarding, modifica el array `layouts` en `OnboardingAdapter`.
 *
 * ## Estándares de Usabilidad y Accesibilidad:
 * 1. **Contraste de texto**: Asegura que el texto en las pantallas de onboarding sea legible
 * con un contraste adecuado.
 * 2. **Interactividad clara**: Los botones y elementos interactivos deben ser fácilmente
 * identificables y accesibles.
 * 3. **Navegación intuitiva**: El usuario debe poder navegar fácilmente entre las pantallas
 * de onboarding.
 *
 * ## Pruebas de Usabilidad y Accesibilidad:
 * Se realizaron pruebas para asegurar que las pantallas de onboarding sean fáciles de usar
 * y accesibles para todos los usuarios.
 *
 * @property viewPager El ViewPager2 que muestra las pantallas de onboarding.
 * @property adapter El adaptador para el ViewPager2.
 */
class OnboardingActivity : AppCompatActivity() {

    /**
     * Método que se ejecuta cuando la actividad es creada.
     *
     * Este método inicializa el ViewPager2 y le asigna el adaptador `OnboardingAdapter`.
     *
     * @param savedInstanceState El estado guardado de la actividad, si existe.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val adapter = OnboardingAdapter(this)
        viewPager.adapter = adapter
    }

    /**
     * Finaliza el onboarding y navega a MainActivity.
     *
     * Este método marca el onboarding como visto en SharedPreferences y luego inicia
     * MainActivity.
     */
    fun finishOnboarding() {
        // Marcar el onboarding como visto
        getSharedPreferences("prefs", MODE_PRIVATE).edit().putBoolean("firstStart", false).apply()
        // Iniciar MainActivity
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}