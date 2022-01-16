package design_patterns.command.remote

class GarageDoorDownCommand(private val garageDoor: GarageDoor) : Command {
    override fun execute() {
        this.garageDoor.up()
    }
}
