package design_patterns.strategy.ducks.fly

class FlyNoWay : FlyBehavior {
    override fun fly() {
        println("I can't fly")
    }
}
