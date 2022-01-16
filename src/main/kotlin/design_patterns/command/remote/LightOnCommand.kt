package design_patterns.command.remote

class LightOnCommand(private val light: Light) : Command {
    override fun execute() {
        this.light.on()
    }
}
