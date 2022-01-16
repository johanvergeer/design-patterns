package design_patterns.command.party

class StereoOnCommand(var stereo: Stereo) : Command {
    override fun execute() {
        this.stereo.on()
    }

    override fun undo() {
        this.stereo.off()
    }
}