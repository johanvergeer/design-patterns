package design_patterns.command.old.party

class TV(var location: String) {
    var channel = 0

    fun on() {
        println("${this.location} TV is on")
    }

    fun off() {
        println("${this.location} TV is off")
    }

    fun setInputChannel() {
        this.channel = 3
        println("${this.location} TV channel is set for DVD")
    }
}
