package design_patterns.command.party

class HottubOffCommand(private var hottub: Hottub) : Command {
    override fun execute() {
        this.hottub.temperature = 98
        this.hottub.off()
    }

    override fun undo() {
        this.hottub.on()
    }
}