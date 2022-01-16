package design_patterns.command.old.party

class StereoOnCommand(var stereo: Stereo) : Command {
    override fun execute() {
        this.stereo.on()
    }

    override fun undo() {
        this.stereo.off()
    }
}
