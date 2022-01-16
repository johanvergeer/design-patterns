package design_patterns.strategy.ducks

import design_patterns.strategy.ducks.fly.FlyBehavior
import design_patterns.strategy.ducks.fly.FlyRocketPowered
import design_patterns.strategy.ducks.quack.QuackBehavior
import kotlin.jvm.JvmStatic

object MiniDuckSimulator {
    @JvmStatic
    fun main(args: Array<String>) {
        val mallard = MallardDuck()

        val cantFly = FlyBehavior { println("I can't fly") }
        val squeak = QuackBehavior { println("Squeak") }
        val rubberDuckie = RubberDuck(cantFly, squeak)

        val decoy = DecoyDuck()

        mallard.performQuack()
        rubberDuckie.performQuack()
        decoy.performQuack()

        val model: Duck = ModelDuck()
        model.performFly()
        model.flyBehavior = FlyRocketPowered()
        model.performFly()
    }
}
