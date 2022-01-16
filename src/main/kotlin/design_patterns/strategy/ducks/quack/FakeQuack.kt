package design_patterns.strategy.ducks.quack

class FakeQuack : QuackBehavior {
    override fun quack() {
        println("Qwak")
    }
}
