package design_patterns.decorator.beverages

import design_patterns.decorator.Beverage

class Espresso : Beverage() {
    override val description = "Espresso"

    override val cost: Double = 1.99
}
