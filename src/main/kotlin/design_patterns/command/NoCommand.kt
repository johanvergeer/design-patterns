package design_patterns.command

class NoCommand : Command {
    override fun execute() {}
    override fun undo() {}
}