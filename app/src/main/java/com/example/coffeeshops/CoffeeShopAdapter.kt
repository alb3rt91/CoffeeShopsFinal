package com.example.coffeeshops

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Adaptador para mostrar una lista de cafeterías en un RecyclerView.
 *
 * Este adaptador maneja la visualización de las cafeterías, incluyendo su imagen, nombre,
 * dirección y calificación. También permite manejar el evento de clic en cada ítem dentro
 * de un RecyclerView, el cual es una vista que muestra una lista de elementos de manera eficiente.
 *
 * ## Manual de instalación:
 * - El adaptador depende de un `RecyclerView` y debe ser configurado correctamente en la actividad
 *   que lo utilice. El RecyclerView debería ser inicializado y el adaptador asignado para mostrar
 *   los ítems en la interfaz.
 *
 * ## Manual de configuración:
 * El adaptador toma un contexto y una lista de objetos [CoffeeShop] para mostrar los datos
 * de las cafeterías. Se pueden agregar o modificar cafeterías en la lista que se pasa al adaptador
 * para actualizar la vista.
 *
 * ## Manual de administración:
 * El adaptador permite manejar la calificación de las cafeterías con un `RatingBar`. Cuando un usuario
 * cambia la calificación, el valor se guarda automáticamente en el objeto correspondiente en la lista.
 *
 * ## Estándares de Usabilidad y Accesibilidad:
 * - **Contraste de colores**: Asegúrate de que el contraste de texto e imágenes sea adecuado
 *   para usuarios con deficiencias visuales. Utiliza colores con suficiente contraste.
 * - **Interactividad clara**: Los botones y elementos interactivos deben ser claramente visibles y fáciles de tocar.
 * - **Textos legibles**: El tamaño y la fuente del texto deben ser lo suficientemente grandes para ser leídos por la mayoría de los usuarios.
 * - **Compatibilidad con lectores de pantalla**: Los elementos importantes, como las imágenes y el texto, deben tener descripciones adecuadas para ser leídos por herramientas de accesibilidad como los lectores de pantalla.
 *
 * ## Pruebas de Usabilidad y Accesibilidad:
 *  Se verificó la interacción de los usuarios con el RecyclerView y la calificación de cafeterías.
 *  También se comprobó que la interfaz sea accesible a usuarios con discapacidades visuales y motoras.
 *  Los `RatingBar` y los clics en los ítems fueron correctamente implementados.
 *
 *
 * @property context El contexto donde se usa el adaptador. El contexto es necesario para inflar las vistas
 * y acceder a los recursos de la aplicación.
 * @property coffeeShops Lista de objetos [CoffeeShop] que se mostrarán en el RecyclerView.
 */
class CoffeeShopAdapter(
    private val context: Context,
    private val coffeeShops: List<CoffeeShop>
) : RecyclerView.Adapter<CoffeeShopAdapter.CoffeeShopViewHolder>() {

    /**
     * Interfaz para manejar el clic en un ítem.
     *
     * Se asigna un bloque de código que se ejecutará cuando el usuario haga clic en un ítem de la lista.
     * Este es un mecanismo de callback que permite que el componente que instancie el adaptador
     * reaccione a la acción de clic.
     *
     * @property onItemClick El bloque de código que se ejecuta al hacer clic en un ítem.
     */
    var onItemClick: ((CoffeeShop) -> Unit)? = null

    /**
     * Crea una nueva vista de ítem y la inicializa.
     *
     * Este método se llama cuando se necesita crear un nuevo ViewHolder para un ítem de la lista en el RecyclerView.
     * Es responsable de inflar el layout del ítem y devolver un ViewHolder con la vista lista para ser usada.
     *
     * @param parent El contenedor en el que se insertará la nueva vista. Este es el RecyclerView donde se mostrarán
     * los elementos.
     * @param viewType El tipo de vista que se va a crear, pero no se usa en este caso.
     * @return Un nuevo [CoffeeShopViewHolder] con la vista inflada que representa un ítem en la lista.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeShopViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_coffee_shop, parent, false)
        return CoffeeShopViewHolder(view)
    }

    /**
     * Asocia los datos de un [CoffeeShop] a las vistas de un ViewHolder.
     *
     * Este método se llama cada vez que un ítem se debe mostrar en el RecyclerView.
     * Se asegura de que los datos de cada cafetería estén correctamente representados en la interfaz de usuario.
     *
     * ## Estándares de Accesibilidad:
     * - **Uso de contenido alternativo en imágenes**: La imagen de cada cafetería debe tener contenido alternativo accesible.
     * - **Tamaño de texto ajustable**: El tamaño del texto debería permitir ser ajustado para usuarios con dificultades de lectura.
     *
     * @param holder El ViewHolder donde se asociarán los datos. Este es el objeto que mantiene las vistas para un ítem.
     * @param position La posición del ítem en la lista. Sirve para obtener los datos correctos de la lista.
     */
    override fun onBindViewHolder(holder: CoffeeShopViewHolder, position: Int) {
        val coffeeShop = coffeeShops[position]
        holder.imageView.setImageResource(coffeeShop.imageResource)
        holder.textViewTitle.text = coffeeShop.name
        holder.textViewStreet.text = coffeeShop.street

        // Configuramos la RatingBar para que empiece en 0
        holder.ratingBar.rating = coffeeShop.rating

        // Configurar el RatingBar para que guarde el valor cuando se modifique
        holder.ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            coffeeShop.rating = rating // Guardamos la calificación en el objeto
        }

        // Manejar clic en el ítem
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(coffeeShop)
        }
    }

    /**
     * Devuelve el número total de ítems en la lista de cafeterías.
     *
     * Este método le dice al RecyclerView cuántos elementos tiene la lista de cafeterías,
     * para que pueda gestionar el número de ítems que se deben mostrar en pantalla.
     *
     * ## Estándares de Accesibilidad:
     * - **Gestión adecuada de las listas**: Cuando hay listas largas, asegurarse de que los elementos puedan ser fácilmente accesibles con teclados o dispositivos de asistencia.
     *
     * @return El tamaño de la lista de cafeterías.
     */
    override fun getItemCount(): Int = coffeeShops.size

    /**
     * ViewHolder para un ítem de cafetería.
     *
     * Este ViewHolder mantiene las vistas que se utilizarán para mostrar los datos
     * de un ítem en la lista de cafeterías. Cada ViewHolder está asociado a un ítem
     * del RecyclerView y se reutiliza a medida que se hace scroll por la lista.
     *
     * ## Estándares de Usabilidad:
     * - **Evitar la sobrecarga cognitiva**: La información debe estar organizada de manera que sea fácil de entender y no sobrecargue al usuario.
     *
     * @property imageView Vista para mostrar la imagen de la cafetería.
     * @property textViewTitle Vista para mostrar el nombre de la cafetería.
     * @property textViewStreet Vista para mostrar la dirección de la cafetería.
     * @property ratingBar Vista para mostrar la calificación de la cafetería.
     */
    class CoffeeShopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        val textViewStreet: TextView = itemView.findViewById(R.id.textViewStreet)
        val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)
    }
}
