package design_patterns.command.remote

class StereoOnWithCDCommand(var stereo: Stereo) : Command {
    override fun execute() {
        this.stereo.on()
        this.stereo.setCD()
        this.stereo.setVolume(11)
    }
}
