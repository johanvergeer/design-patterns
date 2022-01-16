package design_patterns.command.remote_undo

class LightOffCommand(light: Light) : LightCommand(light) {
    override fun switchLight() {
        this.light.off()
    }
}
