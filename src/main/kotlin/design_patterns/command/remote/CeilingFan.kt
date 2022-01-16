package design_patterns.command.remote

class CeilingFan(val location: String = "") {
    var speed: Speed = Speed.LOW
        private set

    /**
     * turns the ceiling fan on to high
     */
    fun high() {
        this.speed = Speed.HIGH
        println("${this.location} ceiling fan is on high")
    }

    /**
     * turns the ceiling fan on to medium
     */
    fun medium() {
        this.speed = Speed.MEDIUM
        println("${this.location} ceiling fan is on medium")
    }

    /**
     * turns the ceiling fan on to low
     */
    fun low() {
        this.speed = Speed.LOW
        println("${this.location} ceiling fan is on low")
    }

    /**
     * turns the ceiling fan off
     */
    fun off() {
        this.speed = Speed.OFF
        println("${this.location} ceiling fan is off")
    }
}
