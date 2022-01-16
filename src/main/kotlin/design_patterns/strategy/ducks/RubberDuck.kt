package design_patterns.strategy.ducks

import design_patterns.strategy.ducks.fly.FlyBehavior
import design_patterns.strategy.ducks.fly.FlyNoWay
import design_patterns.strategy.ducks.quack.QuackBehavior

class RubberDuck(
    flyBehavior: FlyBehavior = FlyNoWay(),
    quackBehavior: QuackBehavior = QuackBehavior { println("Squeak") }
) : Duck(flyBehavior, quackBehavior) {
    override fun display() {
        println("I'm a rubber duckie")
    }
}
