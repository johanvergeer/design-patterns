package design_patterns.command.party

class NoCommand : Command {
    override fun execute() {}
    override fun undo() {}
}