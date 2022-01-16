package design_patterns.command.party

class LivingroomLightOffCommand(var light: Light) : Command {
    override fun execute() {
        this.light.off()
    }

    override fun undo() {
        this.light.on()
    }
}