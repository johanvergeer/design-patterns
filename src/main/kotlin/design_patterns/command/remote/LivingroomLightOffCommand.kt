package design_patterns.command.remote

class LivingroomLightOffCommand(private val light: Light) : Command {
    override fun execute() {
        this.light.off()
    }
}
