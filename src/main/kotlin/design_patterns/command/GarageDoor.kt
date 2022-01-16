package design_patterns.command

enum class GarageDoorState { OPEN, CLOSED }

class GarageDoor {
    var state = GarageDoorState.CLOSED
        private set

    fun open() {
        this.state = GarageDoorState.OPEN
    }

    fun close() {
        this.state = GarageDoorState.CLOSED
    }
}

class GarageDoorOpenCommand(private val garageDoor: GarageDoor) : Command {

    override fun execute() {
        this.garageDoor.open()
    }

    override fun undo() {
        this.garageDoor.close()
    }
}

class GarageDoorCloseCommand(private val garageDoor: GarageDoor) : Command {

    override fun execute() {
        this.garageDoor.close()
    }

    override fun undo() {
        this.garageDoor.open()
    }
}