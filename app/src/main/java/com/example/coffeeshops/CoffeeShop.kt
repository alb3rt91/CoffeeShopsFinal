package com.example.coffeeshops

/**
 * Representa una cafetería con su nombre, dirección, imagen y calificación.
 *
 * Esta clase se utiliza para almacenar la información básica de una cafetería en la aplicación. Los datos de cada cafetería
 * se muestran en una lista y se usan para representar visualmente a las cafeterías en la interfaz.
 *
 * @property name Nombre de la cafetería. Se usa para mostrar el nombre en la interfaz.
 * @property street Dirección de la cafetería. Se muestra en la interfaz junto al nombre.
 * @property imageResource Identificador del recurso de imagen de la cafetería. Este recurso se utiliza para cargar la imagen
 * asociada con la cafetería en la interfaz.
 * @property rating Calificación de la cafetería. Este valor puede ser modificado por los usuarios a través de la UI de la app,
 * con un valor predeterminado de 0f si no se ha asignado una calificación previamente.
 *
 * Esta clase se usa principalmente en la pantalla principal de la aplicación, donde se presentan diferentes cafeterías con
 * sus respectivos detalles.
 */
data class CoffeeShop(
    val name: String,
    val street: String,
    val imageResource: Int,
    var rating: Float = 0f
)
