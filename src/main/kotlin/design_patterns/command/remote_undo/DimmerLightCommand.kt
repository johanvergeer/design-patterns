package design_patterns.command.remote_undo

abstract class DimmerLightCommand(protected val light: Light) : Command {
    protected abstract var prevLevel: Int

    final override fun execute() {
        this.prevLevel = this.light.level
        this.setLightLevel()
    }

    final override fun undo() {
        this.light.dim(this.prevLevel)
    }

    /**
     * set the correct level for the [light]
     */
    abstract fun setLightLevel()
}
