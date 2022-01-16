package design_patterns.strategy.ducks

import design_patterns.strategy.ducks.fly.FlyBehavior
import design_patterns.strategy.ducks.fly.FlyNoWay
import design_patterns.strategy.ducks.quack.Quack
import design_patterns.strategy.ducks.quack.QuackBehavior

class ModelDuck(
    flyBehavior: FlyBehavior = FlyNoWay(),
    quackBehavior: QuackBehavior = Quack()
) : Duck(flyBehavior, quackBehavior) {

    override fun display() {
        println("I'm a model duck")
    }
}
