package design_patterns.command.remote_undo

class NoCommand : Command {
    override fun execute() {}
    override fun undo() {}
}
