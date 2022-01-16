package design_patterns.command.party

class TVOnCommand(var tv: TV) : Command {
    override fun execute() {
        this.tv.on()
        this.tv.setInputChannel()
    }

    override fun undo() {
        this.tv.off()
    }
}