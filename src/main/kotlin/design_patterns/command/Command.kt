package design_patterns.command

interface Command {
    fun execute()
    fun undo()
}