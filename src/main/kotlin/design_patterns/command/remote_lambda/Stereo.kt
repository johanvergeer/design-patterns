package design_patterns.command.remote_lambda

class Stereo(var location: String) {
    fun on() {
        println("${this.location} stereo is on")
    }

    fun off() {
        println("${this.location} stereo is off")
    }

    fun setCD() {
        println("${this.location} stereo is set for CD input")
    }

    fun setDVD() {
        println("${this.location} stereo is set for DVD input")
    }

    fun setRadio() {
        println("${this.location} stereo is set for Radio")
    }

    fun setVolume(volume: Int) {
        // code to set the volume
        // valid range: 1-11 (after all 11 is better than 10, right?)
        println("${this.location} stereo volume set to $volume")
    }
}
