package design_patterns.command.party

class StereoOffCommand(var stereo: Stereo) : Command {
    override fun execute() {
        this.stereo.off()
    }

    override fun undo() {
        this.stereo.on()
    }
}