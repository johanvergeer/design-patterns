package design_patterns.command.old.party

class TVOffCommand(var tv: TV) : Command {
    override fun execute() {
        this.tv.off()
    }

    override fun undo() {
        this.tv.on()
    }
}
