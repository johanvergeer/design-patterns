package design_patterns.command.remote

class CeilingFanOnCommand(private val ceilingFan: CeilingFan) : Command {
    override fun execute() {
        this.ceilingFan.high()
    }
}
