package design_patterns.command.party

class Hottub {
    var on = false
    private var _temperature = 0

    var temperature
        get() = this._temperature
        set(value) {
            if (value > this._temperature) {
                println("Hottub is heating to a steaming ${this._temperature} degrees")
            } else {
                println("Hottub is cooling to ${this._temperature} degrees")
            }
            this._temperature = value
        }

    fun on() {
        this.on = true
    }

    fun off() {
        this.on = false
    }

    fun circulate() {
        if (this.on) {
            println("Hottub is bubbling!")
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
}