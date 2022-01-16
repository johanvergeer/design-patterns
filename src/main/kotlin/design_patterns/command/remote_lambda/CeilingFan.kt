package design_patterns.command.remote_lambda

class CeilingFan(val location: String = "") {
    var speed = CeilingFanSpeed.OFF

    fun high() {
        // turns the ceiling fan on to high
        this.speed = CeilingFanSpeed.HIGH
        println("${this.location} ceiling fan is on high")
    }

    fun medium() {
        // turns the ceiling fan on to medium
        this.speed = CeilingFanSpeed.MEDIUM
        println("${this.location} ceiling fan is on medium")
    }

    fun low() {
        // turns the ceiling fan on to low
        this.speed = CeilingFanSpeed.LOW
        println("${this.location} ceiling fan is on low")
    }

    fun off() {
        // turns the ceiling fan off
        this.speed = CeilingFanSpeed.OFF
        println("${this.location} ceiling fan is off")
    }
}
