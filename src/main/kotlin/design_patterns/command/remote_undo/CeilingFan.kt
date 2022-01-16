package design_patterns.command.remote_undo

class CeilingFan(val location: String) {
    var speed: Speed = Speed.OFF
        private set

    fun high() {
        speed = Speed.HIGH
        println("$location ceiling fan is on high")
    }

    fun medium() {
        speed = Speed.MEDIUM
        println("$location ceiling fan is on medium")
    }

    fun low() {
        speed = Speed.LOW
        println("$location ceiling fan is on low")
    }

    fun off() {
        speed = Speed.OFF
        println("$location ceiling fan is off")
    }
}
