package design_patterns.decorator

import design_patterns.decorator.beverages.DarkRoast
import design_patterns.decorator.beverages.Espresso
import design_patterns.decorator.beverages.HouseBlend
import design_patterns.decorator.condiments.Mocha
import design_patterns.decorator.condiments.Soy
import design_patterns.decorator.condiments.Whip
import java.text.DecimalFormat

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