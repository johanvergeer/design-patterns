package design_patterns.command.party

class LivingroomLightOnCommand(var light: Light) : Command {
    override fun execute() {
        this.light.on()
    }

    override fun undo() {
        this.light.off()
    }
}