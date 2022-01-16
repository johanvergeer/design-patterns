package design_patterns.decorator.beverages

import design_patterns.decorator.Beverage

class HouseBlend : Beverage() {
    override val description = "House Blend Coffee"

    override val cost: Double = 1.99
}
