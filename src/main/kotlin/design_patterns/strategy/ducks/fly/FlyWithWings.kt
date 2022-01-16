package design_patterns.strategy.ducks.fly

class FlyWithWings : FlyBehavior {
    override fun fly() {
        println("I'm flying!!")
    }
}
