package design_patterns.command.remote_undo

class CeilingFanOffCommand(ceilingFan: CeilingFan) : CeilingFanCommand(ceilingFan) {
    override fun setSpeed() {
        this.ceilingFan.off()
    }
}
