package design_patterns.command.old.party

class StereoOnWithCDCommand(var stereo: Stereo) : Command {
    override fun execute() {
        this.stereo.on()
        this.stereo.setCD()
        this.stereo.setVolume(11)
    }

    override fun undo() {
        this.stereo.off()
    }
}
