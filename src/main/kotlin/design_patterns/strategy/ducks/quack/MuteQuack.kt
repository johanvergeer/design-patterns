package design_patterns.strategy.ducks.quack

class MuteQuack : QuackBehavior {
    override fun quack() {
        println("<< Silence >>")
    }
}
