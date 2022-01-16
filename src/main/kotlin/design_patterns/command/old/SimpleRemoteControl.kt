package design_patterns.command.old

class SimpleRemoteControl {
    var command: Command? = null

    fun buttonWasPressed() {
        this.command?.execute()
    }
}
