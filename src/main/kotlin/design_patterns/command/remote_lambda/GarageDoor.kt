package design_patterns.command.remote_lambda

class GarageDoor(var location: String) {
    fun up() {
        println("${this.location} garage Door is Up")
    }

    fun down() {
        println("${this.location} garage Door is Down")
    }

    fun stop() {
        println("${this.location} garage Door is Stopped")
    }

    fun lightOn() {
        println("${this.location} garage light is on")
    }

    fun lightOff() {
        println("${this.location} garage light is off")
    }
}
