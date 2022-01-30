package design_patterns.facade.home_theater.devices

class Amplifier(private val description: String) {

    var tuner: Tuner? = null
        set(value) {
            println("${this.description} setting tuner to ${this.player}")
            field = value
        }

    var player: StreamingPlayer? = null
        set(value) {
            println("${this.description} setting Streaming player to $value")
            field = value
        }

    fun on() {
        println("${this.description} on")
    }

    fun off() {
        println("${this.description} off")
    }

    fun setStereoSound() {
        println("${this.description} stereo mode on")
    }

    fun setSurroundSound() {
        println("${this.description} surround sound on (5 speakers, 1 subwoofer)")
    }

    fun setVolume(level: Int) {
        println("${this.description} setting volume to $level")
    }

    override fun toString(): String {
        return this.description
    }
}
