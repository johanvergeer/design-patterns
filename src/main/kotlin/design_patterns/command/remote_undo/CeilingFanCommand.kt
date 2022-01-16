package design_patterns.command.remote_undo

abstract class CeilingFanCommand(protected val ceilingFan: CeilingFan) : Command {
    private var prevSpeed = Speed.OFF

    final override fun undo() = when (prevSpeed) {
        Speed.HIGH -> ceilingFan.high()
        Speed.MEDIUM -> ceilingFan.medium()
        Speed.LOW -> ceilingFan.low()
        Speed.OFF -> ceilingFan.off()
    }

    final override fun execute() {
        prevSpeed = this.ceilingFan.speed
        this.setSpeed()
    }

    /**
     * Set the [ceilingFan] to the correct speed
     */
    protected abstract fun setSpeed()
}
