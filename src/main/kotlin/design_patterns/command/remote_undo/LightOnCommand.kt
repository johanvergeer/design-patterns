package design_patterns.command.remote_undo

class LightOnCommand(light: Light) : LightCommand(light) {
    override fun switchLight() {
        this.light.on()
    }
}
