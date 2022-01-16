package design_patterns.command.remote_lambda

class Light(val location: String = "") {
    fun on() {
        println("${this.location} light is on")
    }

    fun off() {
        println("${this.location} light is off")
    }
}
