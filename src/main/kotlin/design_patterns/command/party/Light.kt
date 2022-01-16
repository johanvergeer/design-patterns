package design_patterns.command.party

class Light(var location: String) {
    var level = 0

    fun on() {
        this.level = 100
        println("Light is on")
    }

    fun off() {
        this.level = 0
        println("Light is off")
    }

    fun dim(level: Int) {
        this.level = level

        if (level == 0) this.off()
        else println("Light is dimmed to $level%")
    }
}