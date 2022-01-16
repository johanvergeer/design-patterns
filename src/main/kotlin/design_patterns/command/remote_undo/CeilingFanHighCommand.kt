package design_patterns.command.remote_undo

class CeilingFanHighCommand(ceilingFan: CeilingFan) : CeilingFanCommand(ceilingFan) {
    override fun setSpeed() {
        this.ceilingFan.high()
    }
}
