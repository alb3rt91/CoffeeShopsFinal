import com.example.coffeeshops.CoffeeShop
import org.junit.Assert.*
import org.junit.Test

class CoffeeShopTest {

    @Test
    fun testCoffeeShopName() {
        // Crear una instancia de CoffeeShop sin necesidad de usar recursos reales
        val coffeeShop = CoffeeShop("Antico Caffè Greco", "St. Italy, Rome", 0)
        assertEquals("Antico Caffè Greco", coffeeShop.name)
    }

    @Test
    fun testCoffeeShopStreet() {
        val coffeeShop = CoffeeShop("The Roasted Bean", "St. Colon, Madrid", 0)
        assertEquals("St. Colon, Madrid", coffeeShop.street)
    }
}
