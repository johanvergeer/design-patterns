package design_patterns.command.remote_undo

class CeilingFanLowCommand(ceilingFan: CeilingFan) : CeilingFanCommand(ceilingFan) {
    override fun setSpeed() {
        this.ceilingFan.low()
    }
}
