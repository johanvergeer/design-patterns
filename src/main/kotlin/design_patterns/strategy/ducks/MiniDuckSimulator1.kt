package design_patterns.strategy.ducks

import design_patterns.strategy.ducks.fly.FlyRocketPowered

object MiniDuckSimulator1 {
    @JvmStatic
    fun main(args: Array<String>) {
        val mallard: Duck = MallardDuck()
        mallard.performQuack()
        mallard.performFly()

        val model: Duck = ModelDuck()
        model.performFly()
        model.flyBehavior = FlyRocketPowered()
        model.performFly()
    }
}
