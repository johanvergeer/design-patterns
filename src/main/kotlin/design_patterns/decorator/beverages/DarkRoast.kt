package design_patterns.decorator.beverages

import design_patterns.decorator.Beverage

class DarkRoast : Beverage() {
    override val description = "Dark Roast Coffee"

    override val cost: Double = 0.99
}
