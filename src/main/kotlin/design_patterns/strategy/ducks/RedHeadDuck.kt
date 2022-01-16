package design_patterns.strategy.ducks

import design_patterns.strategy.ducks.fly.FlyBehavior
import design_patterns.strategy.ducks.fly.FlyWithWings
import design_patterns.strategy.ducks.quack.Quack
import design_patterns.strategy.ducks.quack.QuackBehavior

class RedHeadDuck(
    flyBehavior: FlyBehavior = FlyWithWings(),
    quackBehavior: QuackBehavior = Quack()
) : Duck(flyBehavior, quackBehavior) {
    override fun display() {
        println("I'm a real Red Headed duck")
    }
}
