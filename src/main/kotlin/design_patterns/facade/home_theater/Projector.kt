package design_patterns.facade.home_theater

class Projector(private val description: String, private val player: StreamingPlayer) {
    fun on() {
        println("${this.description} on")
    }

    fun off() {
        println("${this.description} off")
    }

    fun wideScreenMode() {
        println("${this.description} in widescreen mode (16x9 aspect ratio)")
    }

    fun tvMode() {
        println("${this.description} in tv mode (4x3 aspect ratio)")
    }

    override fun toString(): String {
        return this.description
    }
}