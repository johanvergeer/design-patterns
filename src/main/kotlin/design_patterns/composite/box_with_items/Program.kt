package design_patterns.composite.box_with_items

import java.lang.Appendable
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

const val ITEM_NAME_LENGTH = 20
const val PRICE_LENGTH = 7
const val ITEM_LINE_LENGTH = ITEM_NAME_LENGTH + PRICE_LENGTH + 1

interface PrizedItem {
    val price: Double

    /**
     * Interfaces can contain implementations, but they should never contain state.
     */
    val formattedPrice: String
        get() {
            val priceFormat = DecimalFormat("0.00", DecimalFormatSymbols(Locale.US))
            val formattedPrice: Appendable = StringBuilder("$")
            formattedPrice.append(priceFormat.format(this.price).padStart(PRICE_LENGTH))

            return formattedPrice.toString()
        }
}

data class Box(val contents: Iterable<PrizedItem>) : PrizedItem {
    override val price: Double
        get() {
            return this.contents.sumOf { it.price }
        }

    override fun toString(): String {
        val stringBuilder: StringBuilder = StringBuilder()
        this.contents.forEach { item ->
            stringBuilder.appendLine(item)
        }

        stringBuilder.appendLine("-".repeat(ITEM_LINE_LENGTH))
        stringBuilder.append("Box total price: ".padEnd(ITEM_NAME_LENGTH))
        stringBuilder.appendLine(this.formattedPrice)

        return stringBuilder.toString()
    }
}

data class Item(val name: String, override val price: Double) : PrizedItem {
    override fun toString(): String {
        val stringBuilder: Appendable = StringBuilder(this.name.padEnd(ITEM_NAME_LENGTH))
        stringBuilder.append(this.formattedPrice)
        return stringBuilder.toString()
    }
}

fun main() {

    val boxWithTools = Box(
        contents = listOf(
            Item("Hammer", 50.0),
            Item("Screwdriver", 10.0),
            Item("Drill", 200.0),
        )
    )

    println("Box with tools:")
    println(boxWithTools)
    println("=".repeat(ITEM_LINE_LENGTH))

    val boxWithFood = Box(
        contents = listOf(
            Item("Bread", 1.0),
            Item("Spaghetti Bolognese", 8.0),
        )
    )
    println("Box with food:")
    println(boxWithFood)
    println("=".repeat(ITEM_LINE_LENGTH))

    val outerBox = Box(
        contents = listOf(
            boxWithTools,
            boxWithFood,
            Item("Receipt", 0.0),
            Item("Coupon", 2.0)
        )
    )
    println("Outer box:")
    println(outerBox)
}
