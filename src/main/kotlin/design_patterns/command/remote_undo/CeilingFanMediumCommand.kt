package design_patterns.command.remote_undo

class CeilingFanMediumCommand(ceilingFan: CeilingFan) : CeilingFanCommand(ceilingFan) {
    override fun setSpeed() {
        this.ceilingFan.medium()
    }
}
