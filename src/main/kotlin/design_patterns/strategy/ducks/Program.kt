package design_patterns.strategy.ducks

fun interface FlyBehavior {
    fun fly()
}

//region FlyBehavior implementations
class FlyNoWay : FlyBehavior {
    override fun fly() {
        println("I can't fly")
    }
}

class FlyRocketPowered : FlyBehavior {
    override fun fly() {
        println("I'm flying with a rocket")
    }
}

class FlyWithWings : FlyBehavior {
    override fun fly() {
        println("I'm flying!!")
    }
}
//endregion

fun interface QuackBehavior {
    fun quack()
}

//region QuackBehavior implementations
class Quack : QuackBehavior {
    override fun quack() {
        println("Quack")
    }
}

class Squeak : QuackBehavior {
    override fun quack() {
        println("Squeak")
    }
}

class FakeQuack : QuackBehavior {
    override fun quack() {
        println("Qwak")
    }
}

class MuteQuack : QuackBehavior {
    override fun quack() {
        println("<< Silence >>")
    }
}
//endregion

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

//region Duck implementations
class MallardDuck(
    flyBehavior: FlyBehavior = FlyWithWings(),
    quackBehavior: QuackBehavior = Quack()
) : Duck(flyBehavior, quackBehavior) {
    override fun display() {
        println("I'm a real Mallard duck")
    }
}

class RedHeadDuck(
    flyBehavior: FlyBehavior = FlyWithWings(),
    quackBehavior: QuackBehavior = Quack()
) : Duck(flyBehavior, quackBehavior) {
    override fun display() {
        println("I'm a real Red Headed duck")
    }
}

class DecoyDuck(
    flyBehavior: FlyBehavior = FlyNoWay(),
    quackBehavior: QuackBehavior = MuteQuack()
) : Duck(flyBehavior, quackBehavior) {
    override fun display() {
        println("I'm a duck Decoy")
    }
}

class ModelDuck(
    flyBehavior: FlyBehavior = FlyNoWay(),
    quackBehavior: QuackBehavior = Quack()
) : Duck(flyBehavior, quackBehavior) {

    override fun display() {
        println("I'm a model duck")
    }
}

class RubberDuck(
    flyBehavior: FlyBehavior = FlyNoWay(),
    quackBehavior: QuackBehavior = QuackBehavior { println("Squeak") }
) : Duck(flyBehavior, quackBehavior) {
    override fun display() {
        println("I'm a rubber duckie")
    }
}
//endregion

fun main() {
    val mallard: Duck = MallardDuck()
    mallard.performQuack()
    mallard.performFly()

    val model: Duck = ModelDuck()
    model.performFly()
    model.flyBehavior = FlyRocketPowered()
    model.performFly()

    val cantFly = FlyBehavior { println("I can't fly") }
    val squeak = QuackBehavior { println("Squeak") }
    val rubberDuckie = RubberDuck(cantFly, squeak)

    val decoy = DecoyDuck()

    mallard.performQuack()
    rubberDuckie.performQuack()
    decoy.performQuack()

//        val model: Duck = ModelDuck()
//        model.performFly()
//        model.flyBehavior = FlyRocketPowered()
//        model.performFly()
}
