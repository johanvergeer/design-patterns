package design_patterns.command.remote_lambda

class Light(val location: String = "") {
    fun on() {
        println("$location light is on")
    }

    fun off() {
        println("$location light is off")
    }
}
