package design_patterns.command.party

class HottubOnCommand(private var hottub: Hottub) : Command {
    override fun execute() {
        this.hottub.on()
        this.hottub.temperature = 104
        this.hottub.circulate()
    }

    override fun undo() {
        this.hottub.off()
    }
}