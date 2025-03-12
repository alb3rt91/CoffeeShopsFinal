package com.example.coffeeshops

import org.junit.Test
import org.junit.Assert.*

/**
 * Ejemplo de prueba unitaria local, que se ejecutará en la máquina de desarrollo (host).
 *
 * Esta prueba verifica que la operación de adición básica funciona correctamente.
 * Se espera que la suma de 2 + 2 sea igual a 4.
 *
 * Para obtener más información sobre las pruebas unitarias en Android,
 * consulta la documentación oficial: [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    /**
     * Prueba que verifica si la adición de 2 + 2 es correcta.
     *
     * En este caso, se asegura de que la suma de 2 + 2 sea igual a 4.
     */
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}
