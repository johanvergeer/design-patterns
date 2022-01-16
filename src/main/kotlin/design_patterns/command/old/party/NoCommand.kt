package design_patterns.command.old.party

class NoCommand : Command {
    override fun execute() {}
    override fun undo() {}
}
