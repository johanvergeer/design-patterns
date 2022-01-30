package design_patterns.facade.home_theater.devices

class Tuner(private val description: String, private val amplifier: Amplifier?) {

    var frequency = 0.0
        set(value) {
            println("${this.description} setting frequency to $value")
            field = value
        }

    fun on() {
        println("${this.description} on")
    }

    fun off() {
        println("${this.description} off")
    }

    fun setAm() {
        println("${this.description} setting AM mode")
    }

    fun setFm() {
        println("${this.description} setting FM mode")
    }

    override fun toString(): String {
        return this.description
    }
}
