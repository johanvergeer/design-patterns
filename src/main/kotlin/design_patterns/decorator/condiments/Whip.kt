package design_patterns.decorator.condiments

import design_patterns.decorator.BeverageItem
import design_patterns.decorator.CondimentDecorator

class Whip(beverage: BeverageItem) : CondimentDecorator(beverage) {
    override fun condimentDescription() = "Whip"

    override val condimentCost = 0.20
}