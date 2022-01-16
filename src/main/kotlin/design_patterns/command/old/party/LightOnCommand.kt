package design_patterns.command.old.party

class LightOnCommand(var light: Light) : Command {
    override fun execute() {
        this.light.on()
    }

    override fun undo() {
        this.light.off()
    }
}
