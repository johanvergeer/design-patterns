package design_patterns.command.remote_undo

abstract class LightCommand(protected val light: Light) : Command {
    var level = 0

    final override fun execute() {
        this.level = this.light.level
        this.switchLight()
    }

    final override fun undo() {
        this.light.dim(this.level)
    }

    /**
     * Switch the [light] on or off
     */
    protected abstract fun switchLight()
}
