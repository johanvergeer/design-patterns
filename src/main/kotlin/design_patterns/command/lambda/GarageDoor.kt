package design_patterns.command.lambda

class GarageDoor(var location: String) {
    fun up() {
        println("$location garage Door is Up")
    }

    fun down() {
        println("$location garage Door is Down")
    }

    fun stop() {
        println("$location garage Door is Stopped")
    }

    fun lightOn() {
        println("$location garage light is on")
    }

    fun lightOff() {
        println("$location garage light is off")
    }
}