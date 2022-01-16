package design_patterns.command.old

class NoCommand : Command {
    override fun execute() {}
    override fun undo() {}
}
