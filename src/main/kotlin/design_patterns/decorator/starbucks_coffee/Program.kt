package design_patterns.decorator.starbucks_coffee

import java.text.DecimalFormat

interface BeverageItem {
    val cost: Double
    val description: String
}

abstract class Beverage : BeverageItem

//region beverage implementations
class DarkRoast : Beverage() {
    override val description = "Dark Roast Coffee"

    override val cost: Double = 0.99
}

class Espresso : Beverage() {
    override val description = "Espresso"

    override val cost: Double = 1.99
}

class HouseBlend : Beverage() {
    override val description = "House Blend Coffee"

    override val cost: Double = 1.99
}
//endregion

abstract class CondimentDecorator(private val beverage: BeverageItem) : BeverageItem {

    abstract val condimentCost: Double
    abstract fun condimentDescription(): String

    final override val cost: Double
        get() = this.beverage.cost + this.condimentCost

    final override val description: String = "${this.beverage.description}, ${this.condimentDescription()}"
}

//region condiment implementations
class Mocha(beverage: BeverageItem) : CondimentDecorator(beverage) {
    override fun condimentDescription() = "Mocha"

    override val condimentCost = 0.20
}

class Soy(beverage: BeverageItem) : CondimentDecorator(beverage) {
    override fun condimentDescription() = "Soy"

    override val condimentCost = 0.15
}

class Whip(beverage: BeverageItem) : CondimentDecorator(beverage) {
    override fun condimentDescription() = "Whip"

    override val condimentCost = 0.20
}
//endregion

fun main() {
    val beverage = Espresso()
    printBeverage(beverage)

    var beverage2: BeverageItem = DarkRoast()
    beverage2 = Mocha(beverage2)
    beverage2 = Mocha(beverage2)
    beverage2 = Whip(beverage2)
    printBeverage(beverage2)

    var beverage3: BeverageItem = HouseBlend()
    beverage3 = Soy(beverage3)
    beverage3 = Mocha(beverage3)
    beverage3 = Whip(beverage3)
    printBeverage(beverage3)
}

private fun printBeverage(beverage: BeverageItem) {
    println("${beverage.description} $ ${beverage.cost.roundDecimalPlaces()}")
}

private fun Double.roundDecimalPlaces() = DecimalFormat("#.##").format(this.toBigDecimal())
