package design_patterns.command.remote

class GarageDoorUpCommand(private val garageDoor: GarageDoor) : Command {
    override fun execute() {
        this.garageDoor.up()
    }
}
