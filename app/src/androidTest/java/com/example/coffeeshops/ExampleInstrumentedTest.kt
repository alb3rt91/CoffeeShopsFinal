package com.example.coffeeshops

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

/**
 * Prueba instrumentada que se ejecutará en un dispositivo Android.
 *
 * Esta prueba verifica que el contexto de la aplicación sea el correcto,
 * asegurándose de que el nombre del paquete de la aplicación sea el esperado.
 *
 * Para obtener más información sobre las pruebas instrumentadas en Android,
 * consulta la documentación oficial: [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    /**
     * Prueba para verificar que el contexto de la aplicación es el esperado.
     *
     * En este caso, se asegura de que el nombre del paquete de la aplicación
     * sea "com.example.coffeeshops".
     */
    @Test
    fun useAppContext() {
        // Contexto de la aplicación bajo prueba.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        // Verificar que el nombre del paquete sea el esperado
        assertEquals("com.example.coffeeshops", appContext.packageName)
    }
}
