package design_patterns.command.party

class CeilingFanMediumCommand(var ceilingFan: CeilingFan) : Command {
    var prevSpeed = CeilingFanSpeed.OFF

    override fun execute() {
        this.prevSpeed = this.ceilingFan.speed
        this.ceilingFan.medium()
    }

    override fun undo() {
        when (this.prevSpeed) {
            CeilingFanSpeed.HIGH -> this.ceilingFan.high()
            CeilingFanSpeed.MEDIUM -> this.ceilingFan.medium()
            CeilingFanSpeed.LOW -> this.ceilingFan.low()
            else -> this.ceilingFan.off()
        }
    }
}