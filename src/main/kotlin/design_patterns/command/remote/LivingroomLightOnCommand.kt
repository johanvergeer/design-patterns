package design_patterns.command.remote

class LivingroomLightOnCommand(private val light: Light) : Command {
    override fun execute() {
        this.light.on()
    }
}
