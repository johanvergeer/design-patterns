package design_patterns.facade.home_theater

class StreamingPlayer(private val description: String, private val amplifier: Amplifier) {
    var currentChapter = 0
    var movie: String? = null

    fun on() {
        println("${this.description} on")
    }

    fun off() {
        println("${this.description} off")
    }

    fun play(movie: String) {
        this.movie = movie
        this.currentChapter = 0
        println("${this.description} playing \"$movie\"")
    }

    fun play(chapter: Int) {
        if (this.movie == null) {
            println("${this.description} can't play chapter $chapter no movie selected")
        } else {
            this.currentChapter = chapter
            println("${this.description} playing chapter ${this.currentChapter} of \"${this.movie}\"")
        }
    }

    fun stop() {
        this.currentChapter = 0
        println("${this.description} stopped \"${this.movie}\"")
    }

    fun pause() {
        println("${this.description} paused \"${this.movie}\"")
    }

    fun setTwoChannelAudio() {
        println("${this.description} set two channel audio")
    }

    fun setSurroundAudio() {
        println("${this.description} set surround audio")
    }

    override fun toString(): String {
        return this.description
    }
}