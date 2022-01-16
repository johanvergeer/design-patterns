package design_patterns.decorator.condiments

import design_patterns.decorator.BeverageItem
import design_patterns.decorator.CondimentDecorator

class Soy(beverage: BeverageItem) : CondimentDecorator(beverage) {
    override fun condimentDescription() = "Soy"

    override val condimentCost = 0.15
}