package design_patterns.facade.home_theater

class PopcornPopper(private val description: String) {
    fun on() {
        println("${this.description} on")
    }

    fun off() {
        println("${this.description} off")
    }

    fun pop() {
        println("${this.description} popping popcorn!")
    }

    override fun toString(): String {
        return this.description
    }
}