package design_patterns.command.remote_undo

class DimmerLightOnCommand(light: Light) : DimmerLightCommand(light) {
    override var prevLevel = 0

    override fun setLightLevel() {
        this.light.dim(75)
    }
}
