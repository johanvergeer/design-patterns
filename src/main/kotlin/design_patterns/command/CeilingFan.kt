package design_patterns.command

enum class CeilingFanSpeed {
    OFF,
    LOW,
    MEDIUM,
    HIGH,
}

class CeilingFan(val location: String = "") {
    var speed = CeilingFanSpeed.OFF
        private set

    fun high() {
        this.speed = CeilingFanSpeed.HIGH
        this.printCeilingFanState("on high")
    }

    fun medium() {
        this.speed = CeilingFanSpeed.MEDIUM
        this.printCeilingFanState("on medium")
    }

    fun low() {
        this.speed = CeilingFanSpeed.LOW
        this.printCeilingFanState("on low")
    }

    fun off() {
        this.speed = CeilingFanSpeed.OFF
        this.printCeilingFanState("off")
    }

    private fun printCeilingFanState(state: String) {
        println("Ceiling fan is $state")
    }
}

abstract class CeilingFanCommand(protected val fan: CeilingFan) : Command {
    private var prevSpeed = CeilingFanSpeed.OFF

    abstract fun setSpeed()

    override fun execute() {
        this.prevSpeed = this.fan.speed
        this.setSpeed()
    }

    override fun undo() {
        when (this.prevSpeed) {
            CeilingFanSpeed.OFF -> this.fan.off()
            CeilingFanSpeed.LOW -> this.fan.low()
            CeilingFanSpeed.MEDIUM -> this.fan.medium()
            CeilingFanSpeed.HIGH -> this.fan.high()
        }
    }
}

class CeilingFanHighCommand(fan: CeilingFan) : CeilingFanCommand(fan) {
    override fun setSpeed() {
        this.fan.high()
    }
}

class CeilingFanMediumCommand(fan: CeilingFan) : CeilingFanCommand(fan) {
    override fun setSpeed() {
        this.fan.medium()
    }
}

class CeilingFanLowCommand(fan: CeilingFan) : CeilingFanCommand(fan) {
    override fun setSpeed() {
        this.fan.low()
    }
}

class CeilingFanOffCommand(fan: CeilingFan) : CeilingFanCommand(fan) {
    override fun setSpeed() {
        this.fan.off()
    }
}
