package design_patterns.decorator.beverages

import design_patterns.decorator.Beverage
import design_patterns.decorator.Size

class Espresso : Beverage() {
    override val description = "Espresso"

    override val cost: Double = 1.99
}