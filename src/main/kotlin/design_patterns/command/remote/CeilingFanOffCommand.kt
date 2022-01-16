package design_patterns.command.remote

class CeilingFanOffCommand(private val ceilingFan: CeilingFan) : Command {
    override fun execute() {
        this.ceilingFan.off()
    }
}
