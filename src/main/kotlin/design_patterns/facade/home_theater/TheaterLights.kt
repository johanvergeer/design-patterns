package design_patterns.facade.home_theater

class TheaterLights(private val description: String) {
    fun on() {
        println("${this.description} on")
    }

    fun off() {
        println("${this.description} off")
    }

    fun dim(level: Int) {
        println("${this.description} dimming to $level%")
    }

    override fun toString(): String {
        return this.description
    }
}