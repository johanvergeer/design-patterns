package design_patterns.command.remote

class StereoOffCommand(val stereo: Stereo) : Command {
    override fun execute() {
        this.stereo.off()
    }
}
