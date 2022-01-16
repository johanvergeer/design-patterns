package design_patterns.command.lambda

class Stereo(var location: String) {
    fun on() {
        println("$location stereo is on")
    }

    fun off() {
        println("$location stereo is off")
    }

    fun setCD() {
        println("$location stereo is set for CD input")
    }

    fun setDVD() {
        println("$location stereo is set for DVD input")
    }

    fun setRadio() {
        println("$location stereo is set for Radio")
    }

    fun setVolume(volume: Int) {
        // code to set the volume
        // valid range: 1-11 (after all 11 is better than 10, right?)
        println("$location stereo volume set to $volume")
    }
}