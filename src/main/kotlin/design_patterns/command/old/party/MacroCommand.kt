package design_patterns.command.old.party

class MacroCommand(var commands: Array<Command>) : Command {
    override fun execute() {
        this.commands.forEach { it.execute() }
    }

    /**
     * NOTE:  these commands have to be done backwards to ensure
     * proper undo functionality
     */
    override fun undo() {
        this.commands.reversed().forEach { it.execute() }
    }
}
