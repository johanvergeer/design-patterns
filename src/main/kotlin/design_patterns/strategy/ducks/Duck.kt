package design_patterns.strategy.ducks

import design_patterns.strategy.ducks.fly.FlyBehavior
import design_patterns.strategy.ducks.quack.QuackBehavior

abstract class Duck(var flyBehavior: FlyBehavior, var quackBehavior: QuackBehavior) {

    abstract fun display()
    fun performFly() {
        this.flyBehavior.fly()
    }

    fun performQuack() {
        this.quackBehavior.quack()
    }

    fun swim() {
        println("All ducks float, even decoys!")
    }
}
