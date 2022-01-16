package design_patterns.command.remote_undo

class DimmerLightOffCommand(light: Light) : DimmerLightCommand(light) {
    override var prevLevel = 100

    override fun setLightLevel() {
        this.light.off()
    }
}
