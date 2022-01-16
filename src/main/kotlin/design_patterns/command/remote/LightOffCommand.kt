package design_patterns.command.remote

class LightOffCommand(private val light: Light) : Command {
    override fun execute() {
        this.light.off()
    }
}
