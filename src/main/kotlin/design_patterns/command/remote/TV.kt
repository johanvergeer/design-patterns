package design_patterns.command.remote

class TV(var location: String) {
    var channel = 0
    fun on() {
        println("TV is on")
    }

    fun off() {
        println("TV is off")
    }

    fun setInputChannel() {
        this.channel = 3
        println("Channel is set for VCR")
    }
}
