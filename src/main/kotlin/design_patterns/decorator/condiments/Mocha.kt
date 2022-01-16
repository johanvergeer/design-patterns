package design_patterns.decorator.condiments

import design_patterns.decorator.BeverageItem
import design_patterns.decorator.CondimentDecorator

class Mocha(beverage: BeverageItem) : CondimentDecorator(beverage) {
    override fun condimentDescription() = "Mocha"

    override val condimentCost = 0.20
}
