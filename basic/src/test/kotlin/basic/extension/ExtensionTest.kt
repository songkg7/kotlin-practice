package basic.extension

import org.junit.jupiter.api.Test

internal class ExtensionTest {

    fun Order.maxPricedItemValue(): Float = this.items.maxByOrNull { it.price }?.price ?: 0F
    fun Order.maxPricedItemName() = this.items.maxByOrNull { it.name }?.name ?: "NO_PRODUCTS"

    val Order.commaDelimitedItemNames: String
        get() = items.joinToString { it.name }

    fun <T> T?.nullSafeToString() = this?.toString() ?: "NULL"

    @Test
    internal fun extension() {
        val order = Order(listOf(Item("Bread", 25.0F), Item("Wine", 29.0F), Item("Water", 12.0F)))

        println("Max priced item name: ${order.maxPricedItemValue()}")
        println("Max priced item value: ${order.maxPricedItemName()}")
        println("Items: ${order.commaDelimitedItemNames}")
    }
}