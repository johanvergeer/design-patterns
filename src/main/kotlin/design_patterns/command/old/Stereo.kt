package design_patterns.command.old

enum class StereoState { ON, OFF }

class Stereo {
    var state = StereoState.OFF
        private set
    var volume: Int = 0

    fun on() {
        this.state = StereoState.ON
    }

    fun off() {
        this.state = StereoState.OFF
    }

    fun setCD() {
    }

    fun setDVD() {
    }

    fun setRadio() {
    }
}

class StereoOnWithCDCommand(private val stereo: Stereo) : Command {
    override fun execute() {
        this.stereo.on()
        this.stereo.setCD()
        this.stereo.volume = 11
    }

    override fun undo() {
        this.stereo.off()
    }
}

class StereoOffCommand(private val stereo: Stereo) : Command {
    override fun execute() {
        this.stereo.off()
    }

    override fun undo() {
        this.stereo.on()
    }
}
