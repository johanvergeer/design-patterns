package design_patterns.strategy.ducks

import design_patterns.strategy.ducks.fly.FlyBehavior
import design_patterns.strategy.ducks.fly.FlyNoWay
import design_patterns.strategy.ducks.quack.MuteQuack
import design_patterns.strategy.ducks.quack.QuackBehavior

class DecoyDuck(
    flyBehavior: FlyBehavior = FlyNoWay(),
    quackBehavior: QuackBehavior = MuteQuack()
) : Duck(flyBehavior, quackBehavior) {
    override fun display() {
        println("I'm a duck Decoy")
    }
}
