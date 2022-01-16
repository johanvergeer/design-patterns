package design_patterns.strategy.ducks.fly

class FlyRocketPowered : FlyBehavior {
    override fun fly() {
        println("I'm flying with a rocket")
    }
}
