package design_patterns.facade.home_theater

class Screen(private val description: String) {
    fun up() {
        println("${this.description} going up")
    }

    fun down() {
        println("${this.description} going down")
    }

    override fun toString(): String {
        return this.description
    }
}
