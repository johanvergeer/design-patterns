package design_patterns.strategy.ducks.quack

class Squeak : QuackBehavior {
    override fun quack() {
        println("Squeak")
    }
}
