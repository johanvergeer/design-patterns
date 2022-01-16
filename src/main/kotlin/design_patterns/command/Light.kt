package design_patterns.command

enum class LightState {
    ON,
    OFF
}

class Light {
    var state = LightState.OFF
        private set

    fun on() {
        this.state = LightState.ON
    }

    fun off() {
        this.state = LightState.OFF
    }
}

class LightOnCommand(private val light: Light) : Command {
    override fun execute() {
        this.light.on()
    }

    override fun undo() {
        this.light.off()
    }
}

class LightOffCommand(private val light: Light) : Command {
    override fun execute() {
        this.light.off()
    }

    override fun undo() {
        this.light.on()
    }
}