package design_patterns.command.lambda

class CeilingFan(val location: String = "") {
    var speed = CeilingFanSpeed.OFF

    fun high() {
        // turns the ceiling fan on to high
        speed = CeilingFanSpeed.HIGH
        println("$location ceiling fan is on high")
    }

    fun medium() {
        // turns the ceiling fan on to medium
        speed = CeilingFanSpeed.MEDIUM
        println("$location ceiling fan is on medium")
    }

    fun low() {
        // turns the ceiling fan on to low
        speed = CeilingFanSpeed.LOW
        println("$location ceiling fan is on low")
    }

    fun off() {
        // turns the ceiling fan off
        speed = CeilingFanSpeed.OFF
        println("$location ceiling fan is off")
    }
}