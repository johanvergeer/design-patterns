package design_patterns.decorator

abstract class CondimentDecorator(private val beverage: BeverageItem) : BeverageItem {

    abstract val condimentCost: Double
    abstract fun condimentDescription(): String

    override val cost: Double
        get() = this.beverage.cost + this.condimentCost

    final override val description: String = "${this.beverage.description}, ${this.condimentDescription()}"
}
