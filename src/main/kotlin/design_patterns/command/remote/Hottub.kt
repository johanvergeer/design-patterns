package design_patterns.command.remote

class Hottub {
    var on = false
    var temperature = 0

    fun on() {
        this.on = true
    }

    fun off() {
        this.on = false
    }

    fun bubblesOn() {
        if (this.on) {
            println("Hottub is bubbling!")
        }
    }

    fun bubblesOff() {
        if (this.on) {
            println("Hottub is not bubbling")
        }
    }

    fun jetsOn() {
        if (this.on) {
            println("Hottub jets are on")
        }
    }

    fun jetsOff() {
        if (this.on) {
            println("Hottub jets are off")
        }
    }

    fun heat() {
        this.temperature = 105
        println("Hottub is heating to a steaming 105 degrees")
    }

    fun cool() {
        this.temperature = 98
        println("Hottub is cooling to 98 degrees")
    }
}
