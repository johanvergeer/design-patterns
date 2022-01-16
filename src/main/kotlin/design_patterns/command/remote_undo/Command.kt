package design_patterns.command.remote_undo

interface Command {
    fun execute()
    fun undo()
}
