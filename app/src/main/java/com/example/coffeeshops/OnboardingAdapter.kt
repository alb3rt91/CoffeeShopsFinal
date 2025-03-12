package com.example.coffeeshops

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

/**
 * Adaptador para el ViewPager2 que muestra las pantallas de onboarding.
 *
 * Este adaptador proporciona las vistas para cada pantalla de onboarding.
 *
 * ## Manual de instalación:
 * 1. Asegúrate de que los archivos de layout para las pantallas de onboarding estén creados
 * en la carpeta `res/layout`.
 *
 * ## Manual de configuración:
 * Las pantallas de onboarding se definen en el array `layouts`.
 * Puedes personalizar el contenido de cada pantalla modificando los archivos de layout
 * correspondientes.
 *
 * ## Manual de administración:
 * Para agregar o eliminar pantallas de onboarding, modifica el array `layouts`.
 *
 * ## Estándares de Usabilidad y Accesibilidad:
 * 1. **Contraste de texto**: Asegura que el texto en las pantallas de onboarding sea legible
 * con un contraste adecuado.
 * 2. **Interactividad clara**: Los botones y elementos interactivos deben ser fácilmente
 * identificables y accesibles.
 *
 * ## Pruebas de Usabilidad y Accesibilidad:
 * Se realizaron pruebas para asegurar que las pantallas de onboarding sean fáciles de usar
 * y accesibles para todos los usuarios.
 *
 * @property context El contexto de la actividad.
 * @property layouts Un array de IDs de layout para las pantallas de onboarding.
 */
class OnboardingAdapter(private val context: Context) : RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    private val layouts = intArrayOf(
        R.layout.onboarding_screen_1,
        R.layout.onboarding_screen_2,
        R.layout.onboarding_screen_3
    )

    /**
     * Crea un nuevo ViewHolder para un ítem de la lista.
     *
     * @param parent El ViewGroup padre.
     * @param viewType El tipo de vista.
     * @return Un nuevo OnboardingViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val view = LayoutInflater.from(context).inflate(layouts[viewType], parent, false)
        return OnboardingViewHolder(view)
    }

    /**
     * Asocia los datos a la vista del ViewHolder.
     *
     * @param holder El ViewHolder.
     * @param position La posición del ítem en la lista.
     */
    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        if (position == layouts.size - 1) {
            val button = holder.itemView.findViewById<Button>(R.id.buttonFinish)
            button?.setOnClickListener {
                (context as OnboardingActivity).finishOnboarding()
            }
        }
    }

    /**
     * Devuelve el número total de ítems en la lista.
     *
     * @return El número de ítems.
     */
    override fun getItemCount(): Int = layouts.size

    /**
     * Devuelve el tipo de vista para un ítem en la lista.
     *
     * @param position La posición del ítem.
     * @return El tipo de vista.
     */
    override fun getItemViewType(position: Int): Int = position

    /**
     * ViewHolder para un ítem de onboarding.
     *
     * @property itemView La vista del ítem.
     */
    class OnboardingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}