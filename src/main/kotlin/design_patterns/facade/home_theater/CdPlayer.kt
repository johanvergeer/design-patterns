package design_patterns.facade.home_theater

class CdPlayer(private val description: String, private val amplifier: Amplifier) {
    var currentTrack = 0
    var title: String? = null

    fun on() {
        println("${this.description} on")
    }

    fun off() {
        println("${this.description} off")
    }

    fun eject() {
        this.title = null
        println("${this.description} eject")
    }

    fun play(title: String) {
        this.title = title
        this.currentTrack = 0
        println("${this.description} playing \"$title\"")
    }

    fun play(track: Int) {
        if (this.title == null) {
            println(
                "${this.description} can't play track ${this.currentTrack}, no cd inserted"
            )
        } else {
            this.currentTrack = track
            println("${this.description} playing track ${this.currentTrack}")
        }
    }

    fun stop() {
        this.currentTrack = 0
        println("${this.description} stopped")
    }

    fun pause() {
        println("${this.description} paused \"${this.title}\"")
    }

    override fun toString(): String {
        return this.description
    }
}