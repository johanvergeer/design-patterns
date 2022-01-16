package design_patterns.command

class SimpleRemoteControl {
    var command: Command? = null

    fun buttonWasPressed() {
        this.command?.execute()
    }
}