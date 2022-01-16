package design_patterns.strategy.ducks.quack

class Quack : QuackBehavior {
    override fun quack() {
        println("Quack")
    }
}
